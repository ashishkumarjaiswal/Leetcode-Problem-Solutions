class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        fun(root, "");
        return ans;
    }

    void fun(TreeNode root, String s) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            s = s + Integer.toString(root.val);
            ans.add(s.substring(0, s.length()));
            return;
        }
        // s = s + "->" + Integer.toString(root.val);
        fun(root.left, s + Integer.toString(root.val) + "->");
        fun(root.right, s + Integer.toString(root.val) + "->");
    }
}
