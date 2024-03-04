// https://leetcode.com/problems/jump-game-ii/

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currEnd = 0;
        int furthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            furthest = Math.max(furthest, i + nums[i]);
            if (i == currEnd) {
                jumps++;
                currEnd = furthest;
            }
        }

        return jumps;
    }
}
