//https://leetcode.com/problems/find-largest-value-in-each-tree-row/

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
    List<Integer> result = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {

        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(root);

        // while(!q.isEmpty()) {
        //     int size = q.size();
        //     int max = Integer.MIN_VALUE;
        //     for(int i = 0; i < size; i++) {
        //         TreeNode curr = q.poll();
        //         if(curr.left != null) {
        //             q.add(curr.left);
        //         }
        //         if(curr.right != null) {
        //             q.add(curr.right);
        //         }
        //         max = Math.max(max, curr.val);
        //     }
        //     size++;
        //     result.add(max);
        // }

        dfs(root, 0);

        return result;
    }

    private void dfs(TreeNode root, int level) {
        //base
        if( root == null) return;

        if(level == result.size()) {
            result.add(root.val);
        } else {
            result.set(level, Math.max(result.get(level), root.val));
        }
        //logic
        dfs(root.left, level + 1);

        dfs(root.right, level + 1);
    }
}