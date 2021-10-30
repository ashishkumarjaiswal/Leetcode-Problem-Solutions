class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    boolean ans = false;

    public boolean findTarget(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }

    void dfs(TreeNode root, int k) {
        if (root == null)
            return;
        if (map.containsKey(root.val)) {
            ans = true;
            return;
        }
        map.put((k - root.val), 1);
        dfs(root.left, k);
        dfs(root.right, k);
    }
}
