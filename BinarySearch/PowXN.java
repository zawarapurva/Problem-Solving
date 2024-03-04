// https://leetcode.com/problems/powx-n/

// Time Complexity: O(n log k)
// Space Complexity: O(k)

class Solution {
    public double myPow(double x, int n) {
        return  helper(x, (long) n);
    }

    private double helper(double x, long n) {
        if(n < 0) return 1/helper(x, -1 * n);
        if(n == 0) return 1;

        if(n % 2 == 0) {
            return helper(x * x, n/2);
        } else {
            return x * helper(x * x, (n-1)/2);
        }
    }
}