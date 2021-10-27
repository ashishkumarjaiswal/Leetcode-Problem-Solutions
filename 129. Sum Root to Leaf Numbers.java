class Solution {
    public int sumNumbers(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        fun(root, 0, ans);
        int total = 0;
        for (int i = 0; i < ans.size(); i++) {
            total = total + ans.get(i);
        }
        return total;
    }

    void fun(TreeNode root, int n, List<Integer> ans) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            n = n * 10 + root.val;
            ans.add(n);
            return;
        }
        n = n * 10 + root.val;
        fun(root.left, n, ans);
        fun(root.right, n, ans);
    }
}
