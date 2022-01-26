class Solution {
    public boolean isBalanced(TreeNode root) {
        fun(root);
        return result;
    }

    boolean result = true;

    int fun(TreeNode root) {
        if (root == null)
            return 0;

        int left = fun(root.left);
        int right = fun(root.right);

        if (Math.abs(left - right) > 1)
            result = false;

        return 1 + Math.max(left, right);

    }
}
