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

    static int ans;
    public int helper(TreeNode root) {
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        int totalsum = left + right + root.val;
        int maxSum = Math.max(left , right) + root.val;
        int onlyRoot = root.val;

        ans  = Math.max(ans, Math.max(totalsum, Math.max(maxSum, onlyRoot)));

        return Math.max(maxSum, onlyRoot);
    }
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;

        helper(root);
        return ans;
    }
}