class Solution {
    public Node flatten(Node head) {
        Node start = head, end = head, ans = head;
        if (head == null)
            return head;
        Stack<Node> st = new Stack<>();
        while (end != null) {
            if (end.child != null) {
                Node child = end.child;
                end.child = null;
                if (end.next != null) {
                    st.push(end.next);
                    end.next.prev = null;
                }
                end.next = child;
                child.prev = end;
            }
            start = end;
            end = end.next;
        }
        while (!st.isEmpty()) {
            end = st.pop();
            start.next=end;
            end.prev=start;
            while (end != null) {
                start = end;
                end = end.next;
            }
        }
        return ans;
    }
}
