// https://leetcode.com/problems/partition-labels/

// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int prevLastIdx = map.get(s.charAt(0));
        int prev = 0;
        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) > prevLastIdx){
                prevLastIdx = map.get(s.charAt(i));
            }
            if(i == prevLastIdx){
                result.add(prevLastIdx - prev+1);
                prev = prevLastIdx+1;
            }
        }
        return result;
    }
}