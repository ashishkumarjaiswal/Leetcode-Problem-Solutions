class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        fun(p);
        List<Integer> one = new ArrayList<>(ans);
        ans = new ArrayList<>();
        fun(q);
        if (one.equals(ans))
            return true;
        return false;
    }

    List<Integer> ans = new ArrayList<>();

    void fun(TreeNode root) {
        if (root == null) {
            ans.add(null);
            return;
        }
        ans.add(root.val);
        fun(root.left);
        fun(root.right);
    }
}
