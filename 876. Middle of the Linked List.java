class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode one = head;
        ListNode two = head;
        while (two.next != null) {
            one = one.next;
            if (two.next != null)
                two = two.next;
            if (two.next != null)
                two = two.next;
        }
        return one;
    }
}
