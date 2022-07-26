class Solution {
    List<List<String>> ans;
    int height;
    int width;

    public List<List<String>> printTree(TreeNode root) {
        height = findHeight(root);
        width = (int) Math.pow(2, height) - 1;
        ans = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                list.add("");
            }
            ans.add(list);
        }

        dfs(root, 0, width / 2);

        return ans;
    }

    void dfs(TreeNode root, int i, int j) {
        if (root == null)
            return;

        ans.get(i).set(j, root.val + "");
        dfs(root.left, i + 1, j - ((int) Math.pow(2, height - i - 2)));
        dfs(root.right, i + 1, j + ((int) Math.pow(2, height - i - 2)));
    }

    int findHeight(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }
}
