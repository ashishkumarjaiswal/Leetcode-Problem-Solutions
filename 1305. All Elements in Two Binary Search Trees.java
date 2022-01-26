class Solution {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        fun(root1);
        fun(root2);
        Collections.sort(ans);
        return ans;
    }

    void fun(TreeNode root) {
        if (root == null)
            return;
        ans.add(root.val);
        fun(root.left);
        fun(root.right);
    }
}
