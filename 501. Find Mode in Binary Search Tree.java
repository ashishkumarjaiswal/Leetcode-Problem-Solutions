class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    List<Integer> ans = new ArrayList<>();
    int count = 0;

    public int[] findMode(TreeNode root) {
        fun(root);
        int[] arr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }
        return arr;
    }

    void fun(TreeNode root) {
        if (root == null)
            return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        if (map.get(root.val) == count)
            ans.add(root.val);
        if (map.get(root.val) > count) {
            count = map.get(root.val);
            ans = new ArrayList<>();
            ans.add(root.val);
        }
        fun(root.left);
        fun(root.right);
    }
}
