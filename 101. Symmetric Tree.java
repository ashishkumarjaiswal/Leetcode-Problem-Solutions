class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return fun(root.left, root.right);
    }

    boolean fun(TreeNode l, TreeNode r) {
        if (l == null && r == null)
            return true;
        if (l == null || r == null)
            return false;
        if (l.val != r.val)
            return false;
        return fun(l.left, r.right) && fun(l.right, r.left);
    }
}
