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
    public int height(TreeNode root) {
        if (root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        // update diameter (edges)
        // diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int left = height(root.left);
        int right = height(root.right);

        int diff = Math.abs(left - right);

        if(diff > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }
}