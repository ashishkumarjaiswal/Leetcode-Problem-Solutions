class Solution {
    int count = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return count;
    }

    int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        int diff = Math.abs(left) + Math.abs(right);

        count += diff;

        return left + right + root.val - 1;
    }
}
