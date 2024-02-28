
// https://leetcode.com/problems/daily-temperatures/

// Solution: Monotonic Decreasing Stack
// Time Complexity: O(n)
// Space Complexity: O(n)

class NextHotterDay {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                int k = st.pop();
                result[k] = i - k;
            }
            st.push(i);
        }

        return result;
    }
}