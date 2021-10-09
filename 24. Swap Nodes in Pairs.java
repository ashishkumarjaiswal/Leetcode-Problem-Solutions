class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode sam = new ListNode(-56), ans = sam;
        ans.next=head;
        while (head != null && head.next != null) {
            ans.next = head.next;
            head.next = head.next.next;
            ans.next.next = head;
            ans = ans.next.next;
            head = head.next;
        }
        return sam.next;
    }
}
