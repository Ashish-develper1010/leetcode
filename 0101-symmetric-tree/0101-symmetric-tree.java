class Solution {

    public boolean isEqual(TreeNode root, TreeNode head) {
        if(root == null && head == null) return true;
        if(root == null || head == null) return false;

        boolean left = isEqual(root.left, head.left);
        boolean right = isEqual(root.right, head.right);

        return root.val == head.val && left && right;
    }

    public TreeNode createMirrorImage(TreeNode root) {
        if(root == null) return null;

        TreeNode head = new TreeNode(root.val);

        head.left = createMirrorImage(root.right);
        head.right = createMirrorImage(root.left);

        return head;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        TreeNode head = createMirrorImage(root.left);

        return isEqual(root.right , head);
    }
}