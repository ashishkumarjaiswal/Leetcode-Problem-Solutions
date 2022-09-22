class CBTInserter {
    Queue<TreeNode> q;
    TreeNode root;

    public CBTInserter(TreeNode r) {
        root = r;
        q = new LinkedList<>();
        q.add(root);
    }

    public int insert(int val) {
        while (!q.isEmpty()) {
            TreeNode x = q.peek();

            if (x.left == null) {
                x.left = new TreeNode(val);
                q.add(x.left);
                return x.val;
            } else {
                q.add(x.left);
            }

            if (x.right == null) {
                x.right = new TreeNode(val);
                q.add(x.right);
                q.poll();
                return x.val;
            } else {
                q.add(x.right);
            }

            q.poll();
        }

        return 0;
    }

    public TreeNode get_root() {
        return root;
    }
}
