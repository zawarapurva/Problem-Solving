import java.util.Arrays;
// Solution: Two Pointers
// Time Complexity: O(n log n)
// Space Complexity: O(1)
public class KdiffPairsArray {
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = 1;
        int cnt = 0;
        Arrays.sort(nums);

        while(l < r && r < n) {

            if(l < r &&  r < n && nums[r] - nums[l] > k) {
                l++;
            } else if (l < r &&  r < n && nums[r] - nums[l] < k) {
                r++;
            } else if(l < r &&  r < n && nums[r] - nums[l] == k) {
                l++;
                r++;
                cnt++;
                while(l < n && nums[l]== nums[l-1]){
                    l++;
                }
                while(r < n && nums[r] == nums[r-1]){
                    r++;
                }
            }
            if(l==r){
                r++;
            }

        }

        return cnt++;

    }
}
