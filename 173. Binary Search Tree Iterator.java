class BSTIterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        addLeft(root);
    }

    public void addLeft(TreeNode node) {
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode x = st.pop();
        addLeft(x.right);
        return x.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}
