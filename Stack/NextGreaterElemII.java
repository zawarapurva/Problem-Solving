
// https://leetcode.com/problems/next-greater-element-ii/

// Solution: Monotonic Decreasing Stack
// Time Complexity: O(n)
// Space Complexity: O(n)

class NextGreaterElemII {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for(int i = 0; i < nums.length*2; i++) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i%nums.length]) {
                int k = st.pop();
                result[k] = nums[i%nums.length];
            }
            if(i < nums.length) st.push(i);
        }

        return result;
    }
}