class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        ListNode a = new ListNode(56);
        ListNode b = new ListNode(45);
        ListNode ans = a;
        ListNode all = b;
        while (head != null && head.next != null) {
            a.next = head;
            b.next = head.next;
            a = a.next;
            b = b.next;
            head = head.next.next;
        }
        if (head!= null) {
            a.next = head;
            a = a.next;
        }
        b.next = null;
        a.next = all.next;
        return ans.next;
    }
}
