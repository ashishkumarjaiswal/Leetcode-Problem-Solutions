class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(56);
        ListNode high = new ListNode(56);
        ListNode highStartPoint = high;
        ListNode ans = small;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                high.next = head;
                high = high.next;
            }
            head = head.next;
        }

        high.next = null;
        small.next = highStartPoint.next;

        return ans.next;
    }
}
