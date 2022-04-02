class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        Queue<TreeNode> q = new LinkedList<>();
        int count = 1;
        q.add(root);

        if (depth == 1) {
            TreeNode x = new TreeNode(val);
            x.left = root;
            return x;
        }

        while (!q.isEmpty()) {
            int size = q.size();
            boolean flag = false;

            for (int i = 0; i < size; i++) {
                TreeNode x = q.poll();

                if (count == depth-1) {
                    TreeNode left = new TreeNode(val);
                    TreeNode right = new TreeNode(val);

                    left.left = x.left;
                    right.right = x.right;

                    x.left = left;
                    x.right = right;

                    flag = true;
                }

                if (x.left != null)
                    q.add(x.left);

                if (x.right != null)
                    q.add(x.right);
            }
            if (flag)
                return root;
            count++;
        }
        return root;
    }
}
