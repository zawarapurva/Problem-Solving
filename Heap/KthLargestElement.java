// https://leetcode.com/problems/kth-largest-element-in-an-array/

// Time Complexity: O(n * log(k))
// Space Complexity: O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            while(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}