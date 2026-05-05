
    class Solution {
        public TreeNode helper(TreeNode root) {
            if(root == null) return null;

            TreeNode head = new TreeNode(root.val);

            head.left = helper(root.right);
            head.right = helper(root.left);

            return head;
        }
        public TreeNode invertTree(TreeNode root) {
            if(root == null) return null;
            
            return helper(root);
        }
    }