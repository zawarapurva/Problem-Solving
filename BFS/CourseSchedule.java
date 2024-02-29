// https://leetcode.com/problems/course-schedule/

// Time Complexity: O(n + m)
// Space Complexity: O(n + m)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // HashMap to store prerequisites information
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // Array to store the indegree of each course
        int[] indegree = new int[numCourses];
        Arrays.fill(indegree, 0);

        // Queue to store courses with an indegree of 0
        Queue<Integer> q = new LinkedList<>();

        // Processing prerequisites and populating the map and indegree array
        for (int i = 0; i < prerequisites.length; i++) {
            int courseToTake = prerequisites[i][0];
            int prerequisiteCourse = prerequisites[i][1];

            indegree[courseToTake]++;

            if (map.containsKey(prerequisiteCourse)) {
                List<Integer> list = map.get(prerequisiteCourse);
                list.add(courseToTake);
                map.put(prerequisiteCourse, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(courseToTake);
                map.put(prerequisiteCourse, list);
            }
        }

        // Populating the queue with courses having an indegree of 0
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Processing courses in the queue and updating indegree
        while (!q.isEmpty()) {
            int course = q.poll();
            List<Integer> dependentCourses = map.get(course);
            if (dependentCourses != null) {
                for (int dependentCourse : dependentCourses) {
                    indegree[dependentCourse]--;
                    if (indegree[dependentCourse] == 0) {
                        q.add(dependentCourse);
                    }
                }
            }
        }

        // Checking if there are any courses with a non-zero indegree
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] != 0) {
                return false;
            }
        }
        // All courses can be finished
        return true;
    }
}
