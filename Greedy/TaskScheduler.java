// https://leetcode.com/problems/task-scheduler/

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int cnt = 0;
        for(char task:tasks) {
            map.put(task, map.getOrDefault(task,0)+1);
            cnt = Math.max(cnt, map.get(task));
        }

        int totalSpace = (cnt-1) * (n+1);
        System.out.println(totalSpace);

        for (HashMap.Entry<Character,Integer> entry : map.entrySet()) {
            if(entry.getValue() == cnt) {
                totalSpace++;
            }
        }

        return Math.max(totalSpace, tasks.length);
    }
}