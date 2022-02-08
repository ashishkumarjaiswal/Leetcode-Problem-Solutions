class Solution {
    public List<TreeNode> generateTrees(int n) {
        return fun(1, n);
    }

    public List<TreeNode> fun(int start, int end) {
        if (start > end) {
            List<TreeNode> base = new ArrayList();
            base.add(null);
            return base;
        }

        List<TreeNode> ans = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = fun(start, i - 1);
            List<TreeNode> right = fun(i + 1, end);
            for (TreeNode r : right) {
                for (TreeNode l : left) {
                    TreeNode temp = new TreeNode(i);
                    temp.left = l;
                    temp.right = r;
                    ans.add(temp);
                }
            }
        }
        return ans;
    }

}
