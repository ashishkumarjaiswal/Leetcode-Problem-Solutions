class Solution {
    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        int count = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node x = q.poll();
                for (int j = 0; j < x.children.size(); j++) {
                    q.add(x.children.get(j));
                }
            }
            count++;
        }
        return count;
    }
}
