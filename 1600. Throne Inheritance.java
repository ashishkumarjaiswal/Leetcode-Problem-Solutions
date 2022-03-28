class ThroneInheritance {

    class Node {
        String name;
        boolean alive;
        List<Node> list = new LinkedList<>();

        Node(String name) {
            this.name = name;
            this.alive = true;
        }
    }

    Node node;
    Map<String, Node> map;

    public ThroneInheritance(String kingName) {
        node = new Node(kingName);
        map = new TreeMap<>();
        map.put(kingName, node);
    }

    public void birth(String parentName, String childName) {
        Node x = map.get(parentName);
        Node child = new Node(childName);
        x.list.add(child);
        map.put(childName, child);
    }

    // public Node bfs(String name) {
    // Node temp = node;
    // Queue<Node> q = new LinkedList<>();
    // q.add(temp);

    // while (!q.isEmpty()) {
    // int size = q.size();

    // for (int i = 0; i < size; i++) {
    // Node x = q.poll();

    // if (x.name.equals(name))
    // return x;

    // List<Node> list = x.list;

    // for (int j = 0; j < list.size(); j++) {
    // q.add(list.get(j));
    // }
    // }
    // }
    // return node;
    // }

    public void death(String name) {
        Node x = map.get(name);
        x.alive = false;
    }

    public List<String> getInheritanceOrder() {
        Node temp = node;
        List<String> list = new LinkedList<>();
        dfs(temp, list);
        return list;
    }

    public List<String> dfs(Node temp, List<String> ans) {
        if (temp.alive)
            ans.add(temp.name);

        for (int i = 0; i < temp.list.size(); i++) {
            Node x = temp.list.get(i);

            dfs(x, ans);
        }
        return ans;
    }
}
