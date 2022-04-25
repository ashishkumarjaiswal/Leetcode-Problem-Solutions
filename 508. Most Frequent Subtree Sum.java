class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        dfs(root);

        for (Integer i : map.keySet()) {
            int x = map.get(i);

            if (x == max) {
                list.add(i);
            }
        }

        int[] arr = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        int sum = left + right + root.val;

        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max = Math.max(max, map.get(sum));

        return sum;
    }
}
