class LRUCache {

    public class Node {
        Node next;
        Node prev;
        int key;
        int val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    HashMap<Integer, Node> map = new HashMap<>();
    Node head, tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node x = map.get(key);
        if (x == null)
            return -1;
        remove(x);
        insert(x);
        return x.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key))
            remove(map.get(key));
        

        if (map.size() == capacity)
            remove(tail.prev);

        insert(new Node(key, value));
    }

    void insert(Node x) {
        map.put(x.key, x);
        x.next = head.next;
        x.prev = head;
        x.prev.next = x;
        x.next.prev = x;

    }

    void remove(Node x) {
        map.remove(x.key);
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }
}
