class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode root, String path, List<String> result) {
        if (root == null) return;

        // Add current node to path
        if (path.length() == 0) {
            path += root.val;
        } else {
            path += "->" + root.val;
        }

        // If leaf node → add to result
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        // Recurse left and right
        dfs(root.left, path, result);
        dfs(root.right, path, result);
    }
}