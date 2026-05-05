class Solution {
    public boolean helper(TreeNode root, int targetSum, int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null && sum + root.val == targetSum)
            return true;

        boolean left = helper(root.left, targetSum, sum + root.val);
        boolean right = helper(root.right, targetSum, sum + root.val);

        return left || right;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        return helper(root, targetSum, 0);
    }
}