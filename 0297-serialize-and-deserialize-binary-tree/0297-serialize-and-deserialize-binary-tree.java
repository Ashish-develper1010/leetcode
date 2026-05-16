public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N,");
            return;
        }

        sb.append(root.val).append(",");

        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        int[] index = new int[1];

        return buildTree(arr, index);
    }

    private TreeNode buildTree(String[] arr, int[] index) {

        if (arr[index[0]].equals("N")) {
            index[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[index[0]]));
        index[0]++;

        root.left = buildTree(arr, index);
        root.right = buildTree(arr, index);

        return root;
    }
}