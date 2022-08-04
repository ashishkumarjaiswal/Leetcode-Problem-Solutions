class Solution {
    public TreeNode pruneTree(TreeNode root) {
        fun(root);

        if (root.val == 0 && root.left == null && root.right == null)
            return null;
        return root;
    }

    boolean fun(TreeNode root) {
        if (root == null)
            return true;

        if (root.left == null && root.right == null) {
            if (root.val == 0)
                return true;

            return false;
        }

        boolean left = fun(root.left);
        boolean right = fun(root.right);

        if (left) {
            root.left = null;
        }
        if (right) {
            root.right = null;
        }

        return root.val == 0 && left && right;
    }
}
