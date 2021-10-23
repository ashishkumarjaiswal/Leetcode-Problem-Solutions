class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;
        ListNode ans = head;
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
                continue;
            }
            head = head.next;
        }
        if (ans.val == val)
            return ans.next;
        return ans;
    }
}
