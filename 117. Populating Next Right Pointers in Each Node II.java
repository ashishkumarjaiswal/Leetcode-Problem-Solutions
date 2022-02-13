class Solution {
    Queue<Node> q = new LinkedList<>();

    public Node connect(Node root) {
        if (root == null)
            return root;

        Node ans = root;

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            Node x=new Node();
            for (int i = 0; i < size; i++) {
                x = q.poll();
                fun(x);
                x.next = q.peek();
            }
            x.next = null;
        }
        return root;
    }

    void fun(Node root) {
        if (root == null)
            return;

        if (root.left != null)
            q.add(root.left);

        if (root.right != null)
            q.add(root.right);
    }
}
