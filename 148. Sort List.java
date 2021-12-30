class Solution {
    public ListNode sortList(ListNode head) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        if (head == null)
            return head;
        while (head != null) {
            q.add(head.val);
            head = head.next;
        }
        ListNode ans = new ListNode(56);
        ListNode result = ans;
        while (!q.isEmpty()) {
            ans.next = new ListNode(q.poll());
            ans = ans.next;
        }
        return result.next;
    }
}
