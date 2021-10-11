class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        fun(root);
        return max;
    }

    int fun(TreeNode root) {
        if (root == null)
            return 0;
        int x = fun(root.left);
        int y = fun(root.right);
        int z = Math.max(Math.max(x + y + root.val, root.val), Math.max(y + root.val, x + root.val));
        if (z > max)
            max = z;
        return Math.max(Math.max(x + root.val, y + root.val), root.val);
    }
}
