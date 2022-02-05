class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;
        Node curr = head;

        while (curr != null) {
            Node temp = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = temp;
            curr = temp;
        }

        curr = head;
        while (curr != null) {
            curr.next.random = curr.random == null ? null : curr.random.next;
            curr = curr.next.next;
        }

        curr = head;
        Node ori = head.next;
        Node ans = ori;
        while (curr != null) {
            curr.next = curr.next.next;
            ori.next = ori.next == null ? null : ori.next.next;
            curr = curr.next;
            ori = ori.next;
        }
        return ans;

    }
}
