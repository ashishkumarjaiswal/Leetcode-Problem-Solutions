class Solution {
    HashMap<String, Integer> map;
    List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ans = new LinkedList<>();
        map = new HashMap<>();
        fun(root);
        return ans;
    }

    String fun(TreeNode root) {
        if (root == null)
            return "x";

        String l = fun(root.left);
        String r = fun(root.right);
        String t = root.val + " " + l + " " + r;
        map.put(t, map.getOrDefault(t, 0) + 1);
        if (map.get(t) == 2)
            ans.add(root);

        return t;
    }
}
