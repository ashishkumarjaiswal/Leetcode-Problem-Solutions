class Solution {
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        return fun(root);
    }

    int fun(TreeNode root) {
        if (root == null)
            return 0;
        int x = 1 + fun(root.left) + fun(root.right);
        return x;
    }
}
