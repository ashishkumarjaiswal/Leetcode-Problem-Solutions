class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return node;

        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        map.put(node, new Node(node.val, new ArrayList<Node>()));

        while (!q.isEmpty()) {
            Node x = q.poll();
            for (Node i : x.neighbors) {
                if (!map.containsKey(i)) {
                    map.put(i, new Node(i.val, new ArrayList<Node>()));
                    q.add(i);
                }
                map.get(x).neighbors.add(map.get(i));
            }
        }
        return map.get(node);
    }
}
