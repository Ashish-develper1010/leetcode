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

        int sum1 = left + right + root.val;
        int sum2 = Math.max(left, right) + root.val;
        int sum3 = root.val;

        ans = Math.max(ans, Math.max(sum1, Math.max(sum2, sum3)));

        return Math.max(sum2, sum3);
    }
    public int maxPathSum(TreeNode root) {
        // if(root == null) return 0;

        ans = Integer.MIN_VALUE;

        helper(root);

        return ans;
    }
}