class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode x = q.poll();

            if (x.val == subRoot.val) {
                if (fun(x, subRoot))
                    return true;
            }

            if (x.left != null)
                q.add(x.left);

            if (x.right != null)
                q.add(x.right);
        }
        return false;
    }

    boolean fun(TreeNode x, TreeNode y) {
        if (x == null && y == null)
            return true;

        if (x == null || y == null)
            return false;

        if (x.val != y.val) {
            return false;
        }

        return fun(x.left, y.left) && fun(x.right, y.right);
    }
}
