class Solution {
    int total = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;

        convertBST(root.right);
        int temp = root.val;
        root.val += total;
        total += temp;
        convertBST(root.left);
        return root;
    }
}
