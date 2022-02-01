class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null || left==right)
            return head;

        int dep = left;

        ListNode front = new ListNode(56);
        front.next = head;

        while (front != null && left > 1) {
            front = front.next;
            left--;
        }

        ListNode last = head;

        while (right-- > 1) {
            last = last.next;
        }

        ListNode temp = last;

        last = last.next;
        temp.next = null;

        ListNode toRev = front.next;

        reverse(toRev);

        front.next = start;
        end.next = last;

        if (dep == 1)
            return front.next;

        return head;

    }

    ListNode start = null, end = null;

    void reverse(ListNode head) {
        if (head == null || head.next == null)
            return;
        while (head != null) {
            ListNode x = head;
            head = head.next;
            if (end == null)
                end = x;
            x.next = start;
            start = x;
        }
    }
}
