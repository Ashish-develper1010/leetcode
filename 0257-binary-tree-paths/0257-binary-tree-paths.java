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
    public void dfs(TreeNode root, String str, List<String> res) {
        if(root == null) return;

        if(str.length() == 0) {
            str += root.val;
        }
        else {
            str += ("->" + root.val);
        }

        if(root.left == null && root.right == null) {
            res.add(str);
            return;
        }

        dfs(root.left , str, res);
        dfs(root.right , str, res);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        dfs(root , "", res);

        return res;
    }
}