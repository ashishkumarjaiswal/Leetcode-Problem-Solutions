class Solution {
    Queue<TreeNode> q = new LinkedList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> curr = new ArrayList<>();
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode x = q.poll();
                curr.add(x.val);
                fun(x);
            }
            ans.add(0, curr);

        }

        return ans;
    }

    void fun(TreeNode root) {
        if (root == null)
            return;

        if (root.left != null)
            q.add(root.left);

        if (root.right != null)
            q.add(root.right);
    }
}
