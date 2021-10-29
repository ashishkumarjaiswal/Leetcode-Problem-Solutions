class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode ashish = new TreeNode();
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        return fun(root, val);
    }

    TreeNode fun(TreeNode root, int val) {
        if (root.val < val) {
            if (root.right == null) {
                root.right = new TreeNode();
                root.right.val = val;
                return root;
            } else {
                fun(root.right, val);
            }
        } else {
            if (root.left == null) {
                root.left = new TreeNode();
                root.left.val = val;
                return root;
            } else {
                fun(root.left, val);
            }
        }
        return root;
    }
}
