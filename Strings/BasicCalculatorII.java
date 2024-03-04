// https://leetcode.com/problems/basic-calculator-ii/

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int calculate(String s) {
        s = s.trim();
        int calc = 0;
        int curr = 0;
        int tail = 0;
        char lastExp = '+';
        for(int i = 0; i< s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                curr = curr*10 + ch - '0';
            }
            if((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                if(lastExp == '+' ) {
                    calc += curr;
                    tail = curr;
                } else if(lastExp == '-') {
                    calc -= curr;
                    tail = -curr;
                } else if(lastExp == '*') {
                    calc = calc - tail + tail * curr;
                    tail = tail * curr;
                } else {
                    calc = calc - tail + tail / curr;
                    tail = tail/curr;
                }
                curr = 0;
                lastExp = ch;
            }
        }

        return calc;
    }
}