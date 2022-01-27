class Solution {
    List<Integer> node = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        int ans = Integer.MAX_VALUE;
        fun(root);
        Collections.sort(node);
        for (int i = 1; i < node.size(); i++) {
            ans = Math.min(ans, Math.abs(node.get(i - 1) - node.get(i)));
        }
        return ans;
    }

    void fun(TreeNode root) {
        if (root == null)
            return;
        node.add(root.val);
        fun(root.left);
        fun(root.right);
    }
}
