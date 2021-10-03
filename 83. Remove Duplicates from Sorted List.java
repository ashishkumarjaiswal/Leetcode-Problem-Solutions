class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = head;
        if (head == null)
            return head;
        while (head.next != null) {
            if (head.val == head.next.val)
                head.next = head.next.next;
            else
                head = head.next;
        }
        return res;
    }
}
