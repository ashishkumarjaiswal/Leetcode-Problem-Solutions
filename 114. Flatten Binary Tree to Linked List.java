class Solution {
    List<Integer> ans = new ArrayList<>();

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        fun(root);
        int i = 1;
        while (i < ans.size()) {
            root.left = null;
            root.right = new TreeNode(ans.get(i));
            i++;
            root = root.right;
        }
    }

    void fun(TreeNode root) {
        if (root == null)
            return;
        ans.add(root.val);
        fun(root.left);
        fun(root.right);
    }
}
