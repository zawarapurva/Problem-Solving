// https://leetcode.com/problems/balanced-binary-tree/

// Time Complexity: O(n log n)
// Space Complexity: O(n)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int hr = height(root.right);
        int hl = height(root.left);

        int diff = Math.abs(hr - hl);

        if(diff > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if(root == null) return 0;
        int heightLeft = 1 + height(root.left);
        int heightRight = 1 + height(root.right);

        return Math.max(heightLeft, heightRight);
    }
}