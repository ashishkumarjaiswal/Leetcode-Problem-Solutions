class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        return fun(root, val);
    }

    TreeNode fun(TreeNode root, int val) {
        if (root.val == val)
            return root;
        if (root.val < val) {
            if (root.right != null) {
                root = root.right;
                return fun(root, val);
            } else
                return null;
        } else {
            if (root.left != null) {
                root = root.left;
                return fun(root, val);
            } else
                return null;
        }

    }
}
