class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode a = head;
        ListNode f = head;
        int count = 0;
        if (head.next == null) {
            head = null;
            return head;
        }
        for (int i = 0; i <= n; i++) {
            if (a.next == null) {
                count++;
                if (count != n) {
                    head.next = head.next.next;
                    return head;
                } else {
                    break;
                }
            }
            count++;
            a = a.next;
        }
        if (count == n) {
            head = head.next;
            return head;
        }
        while (a != null) {
            a = a.next;
            head = head.next;
        }
        if (head.next == null) {
            head.next = null;
            return head;
        }
        head.next = head.next.next;
        return f;
    }
}
