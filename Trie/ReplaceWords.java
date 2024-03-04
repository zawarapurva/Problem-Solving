// https://leetcode.com/problems/replace-words/
// Time Complexity: O(NL + KM)
// Space Complexity: O(C + L + M).

class Solution {
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }
    private TrieNode root;

    public void insert(TrieNode root, String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();

        for(String s : dictionary) {
            insert(root, s);
        }

        String[] strArr = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for(String str: strArr) {
            String word = str;
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            for(int k = 0; k < word.length(); k++) {
                char ch = word.charAt(k);
                if(curr.children[ch - 'a'] == null) replacement.append(word.charAt(k));
                curr = curr.children[ch - 'a'];
            }
            if(curr.isEnd) sb.append(replacement);
        }

        return sb.toString();
    }
}