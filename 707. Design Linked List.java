class MyLinkedList {
    class Node {
        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
        }
    }

    Node x = new Node(-1);
    Node y = new Node(-1);

    public MyLinkedList() {
        x.next = y;
        y.prev = x;
    }

    public int get(int index) {
        int i = -1;
        Node n = x;
        while (n.next.next != null && i < index) {
            n = n.next;
            i++;
        }
        if (i == index)
            return n.val;
        return -1;
    }

    public void addAtHead(int val) {
        Node a = new Node(val);
        a.next = x.next;
        a.prev = x;
        a.next.prev = a;
        a.prev.next = a;
    }

    public void addAtTail(int val) {
        Node a = new Node(val);
        a.next = y;
        a.prev = y.prev;
        a.next.prev = a;
        a.prev.next = a;
    }

    public void addAtIndex(int index, int val) {
        Node node = new Node(val);
        Node n = x.next;
        int i = 0;
        while (i < index && n.next != null) {
            i++;
            n = n.next;
        }
        if (n.next == null && i != index)
            return;

        node.prev = n.prev;
        node.next = n;
        node.prev.next = node;
        node.next.prev = node;
    }

    public void deleteAtIndex(int index) {
        Node n = x.next;
        int i = 0;
        while (i < index && n.next != null) {
            i++;
            n = n.next;
        }
        if (n.next == null)
            return;

        n.next.prev = n.prev;
        n.prev.next = n.next;
    }
}
