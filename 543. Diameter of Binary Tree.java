class Solution {
    int d = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        int ans = 0;
        if (root == null)
            return 0;
        fun(root);
        return d;
    }

    public int fun(TreeNode root) {
        if (root == null)
            return 0;
        int l = fun(root.left);
        int r = fun(root.right);
        d = Math.max(d, l + r);
        int x = Math.max(r, l);
        return (x + 1);
    }
}
