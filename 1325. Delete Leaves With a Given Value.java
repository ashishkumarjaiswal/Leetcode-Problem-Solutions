class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        dfs(root, target);
        if (root.left == null && root.right == null && root.val == target)
            root = null;
        return root;
    }

    int dfs(TreeNode root, int target) {
        if (root == null)
            return -1;

        if (root.left == null && root.right == null && root.val == target) {
            return -1;
        }

        int left = dfs(root.left, target);
        int right = dfs(root.right, target);

        if (left == -1) {
            root.left = null;
        }

        if (right == -1) {
            root.right = null;
        }

        if (left == -1 && right == -1 && root.val == target) {
            return -1;
        }

        return 1;
    }
}
