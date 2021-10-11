public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int x = fun(headA);
        int y = fun(headB);
        if (x > y) {
            x = x - y;
            while (x > 0) {
                headA = headA.next;
                x--;
            }
        } else {
            y = y - x;
            while (y > 0) {
                y--;
                headB = headB.next;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    int fun(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
