// https://leetcode.com/problems/queue-reconstruction-by-height/

// Time Complexity: O(nlog(n))
// Space Complexity: O(n)

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        System.out.println(Arrays.deepToString(people));

        List<int[]> q = new ArrayList<>();
        for(int[] p : people) {
            q.add(p[1], p);
        }

        int[][] result = new int[people.length][2];
        for(int i = 0; i < result.length; i++) {
            result[i] = q.get(i);
        }

        return result;
    }
}
