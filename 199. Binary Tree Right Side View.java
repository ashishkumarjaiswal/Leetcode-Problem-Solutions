class Solution {
    int total = 0;
    List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        fun(root, 0);
        return ans;
    }

    void fun(TreeNode root, int count) {
        if (root == null)
            return;
        count++;
        if (count > total) {
            total = count;
            ans.add(root.val);
        }
        fun(root.right, count );
        fun(root.left, count );
    }
}
