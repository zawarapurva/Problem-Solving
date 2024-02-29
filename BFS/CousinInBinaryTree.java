// https://leetcode.com/problems/cousins-in-binary-tree/
// Time Complexity: O(n)
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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode xParent = null, yParent =null;
        boolean xFound = false, yFound = false;
        if(root == null) return false;

        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if(curr.left != null) {
                    q.add(curr.left);
                    if(curr.left.val == x) {
                        xParent = curr;
                        xFound = true;
                    }
                    if(curr.left.val == y) {
                        yParent = curr;
                        yFound = true;
                    }
                }
                if(curr.right != null) {
                    q.add(curr.right);
                    if(curr.right.val == x) {
                        xParent = curr;
                        xFound = true;
                    }
                    if(curr.right.val == y) {
                        yParent = curr;
                        yFound = true;
                    }
                }
                if(xFound && yFound && xParent != yParent) return true;
            }
            xFound = false;
            yFound = false;
        }
        return false;
    }
}