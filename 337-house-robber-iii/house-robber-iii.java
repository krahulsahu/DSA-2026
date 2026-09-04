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

    public int rob(TreeNode root) {

        int[] result = solve(root);

        return Math.max(result[0], result[1]);
    }

    private int[] solve(TreeNode node) {

        // No node
        if (node == null) {
            return new int[]{0, 0};
        }

        // Get results from children
        int[] left = solve(node.left);
        int[] right = solve(node.right);

        // Case 1: Rob current node
        // Therefore, children cannot be robbed
        int rob = node.val + left[0] + right[0];

        // Case 2: Don't rob current node
        // Children can either be robbed or skipped
        int skip = Math.max(left[0], left[1])
                 + Math.max(right[0], right[1]);

        // [skip, rob]
        return new int[]{skip, rob};
    }
}