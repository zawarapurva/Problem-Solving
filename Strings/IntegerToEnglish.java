// https://leetcode.com/problems/integer-to-english-words/

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String result = "";
        int i = 0;
        while(num > 0) {
            int triplet = num % 1000;
            if(triplet != 0) {
                result = helper(triplet).trim() + " " + thousands[i] + " " + result;
            }
            num = num/1000;
            i++;
        }
        return result.trim();
    }

    private String helper(int nums) {
        if(nums < 20 ) return below20[nums];
        else if( nums < 100) return tens[nums/10] + " " + helper(nums%10);
        else return below20[nums/100] + " Hundred " + helper(nums%100);
    }
}