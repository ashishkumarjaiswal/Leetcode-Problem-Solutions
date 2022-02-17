class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            double average = 0;
            for (int i = 0; i < size; i++) {
                TreeNode x = q.poll();
                average = average + x.val;

                if (x.left != null)
                    q.add(x.left);

                if (x.right != null)
                    q.add(x.right);
            }
            average = average / size;
            ans.add(average);
        }
        return ans;
    }
}
