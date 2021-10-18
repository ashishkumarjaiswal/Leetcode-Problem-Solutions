class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        fun(root, ans);
        return ans;
    }

    void fun(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;
        ans.add(root.val);
        fun(root.left, ans);
        fun(root.right, ans);
    }
}
