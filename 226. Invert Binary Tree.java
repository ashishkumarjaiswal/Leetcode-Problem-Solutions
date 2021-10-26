class Solution {
    public TreeNode invertTree(TreeNode root) {
        fun(root);
        return root;
    }

    void fun(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        fun(root.left);
        fun(root.right);
    }
}
