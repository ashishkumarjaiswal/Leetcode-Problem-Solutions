class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return fun(root, 0);
    }

    int fun(TreeNode root, int count) {
        if (root == null)
            return 0;
        count++;
        int x = Math.max(fun(root.left, count), fun(root.right, count));
        return (x + 1);
    }
}
