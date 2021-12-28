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
//Same Approch
class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null)
            return head;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
