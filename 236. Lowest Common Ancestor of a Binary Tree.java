class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        fun(root, p.val, q.val);
        return ans;
    }

    TreeNode ans = null;

    boolean fun(TreeNode root, int p, int q) {
        if (root == null)
            return false;
        boolean self = root.val == p || root.val == q;

        boolean left = fun(root.left, p, q);
        if (ans != null)
            return true;

        boolean right = fun(root.right, p, q);
        if (ans != null)
            return true;

        if ((self && left) || (right && left) || (self && right)) {
            if (ans == null) {
                ans = root;
            }
        }
        return self || left || right;
    }
}
