
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode start = head, tail = head.next;

        while (tail != null) {
            int count = 0;
            while (tail != null && tail.val != 0) {
                count = count + tail.val;
                tail = tail.next;
            }
            tail.val = count;
            start.next = tail;
            start = start.next;
            tail = tail.next;
        }
        return head.next;
    }
}
