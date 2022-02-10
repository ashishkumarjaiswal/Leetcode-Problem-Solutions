class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode mid = middle(head);
        ListNode rev = reverse(mid);
        ListNode prev = null;

        while (head != null && rev != null) {
            ListNode temp = head;
            prev = head;
            head = head.next;
            temp.next = rev;
            rev = rev.next;
            temp.next.next = head;
        }
        if (rev != null)
            prev.next.next = rev;

    }

    ListNode middle(ListNode head) {
        ListNode slow = head, fast = head, prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if (prev != null)
            prev.next = null;
        return slow;
    }

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode ans = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return ans;
    }
}
