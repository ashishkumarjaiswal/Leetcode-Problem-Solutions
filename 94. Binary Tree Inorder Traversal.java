class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ashish = new ArrayList<>();
        in(ashish, root);
        return ashish;
    }

    void in(List<Integer> ashish, TreeNode root) {
        if (root == null)
            return;
        in(ashish, root.left);
        ashish.add(root.val);
        in(ashish, root.right);
    }
}
