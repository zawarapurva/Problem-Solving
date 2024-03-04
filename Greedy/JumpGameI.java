// https://leetcode.com/problems/jump-game/description/

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int target = n - 1;
        for( int i = n-2; i >= 0; i--) {
            if(i + nums[i] >= target){
                target = i;
            }
        }

        return target == 0;
    }
}