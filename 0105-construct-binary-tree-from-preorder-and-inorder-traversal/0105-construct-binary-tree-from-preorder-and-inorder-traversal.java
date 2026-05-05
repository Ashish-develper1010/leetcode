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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length) return null;
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if(prestart > preend || instart > inend) return null;

        // Take root from preorder
        int rootval = preorder[prestart];
        TreeNode root = new TreeNode(rootval);

        // Find root in inorder
        int rootindex = instart;
        for(; rootindex <= inend; rootindex++) {
            if(inorder[rootindex] == rootval) break;
        }

        // Calculate the size of the left subtree
        int leftsize = rootindex - instart;

        // Build left and right tree recursively
        root.left = buildTreeHelper(preorder, prestart + 1, prestart + leftsize, inorder, instart, rootindex - 1);
        root.right = buildTreeHelper(preorder, prestart + leftsize + 1, preend, inorder, rootindex + 1, inend);
        
        return root;
    }
}
