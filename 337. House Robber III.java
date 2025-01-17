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
        // Get the maximum rob amounts from the root node
        int[] result = robSub(root);
        // Return the maximum between robbing and not robbing the root
        return Math.max(result[0], result[1]);
    }

    private int[] robSub(TreeNode root) {
        // Base case: if the node is null, return {0, 0}
        if (root == null) {
            return new int[2];
        }

        // Recursively calculate the results for the left and right subtrees
        int[] left = robSub(root.left);
        int[] right = robSub(root.right);

        // Result array: [not robbed, robbed]
        int[] result = new int[2];

        // If the current node is not robbed
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        // If the current node is robbed
        result[1] = root.val + left[0] + right[0];

        return result;
    }
}
