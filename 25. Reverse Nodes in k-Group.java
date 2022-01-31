import java.util.*;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        int len = len(head);
        ListNode curr = head;
        ListNode a = null, b = null;
        while (len >= k) {
            int x = k;
            while (x-- > 0) {
                ListNode n = curr;
                curr = curr.next;
                n.next = null;
                fun(n);
            }
            if (a == null) {
                a = start;
                b = end;
            } else {
                b.next = start;
                b = end;
            }
            len = len - k;
            start = end = null;
        }
        b.next = curr;
        return a;
    }

    ListNode start = null, end = null;

    void fun(ListNode head) {
        if (start == null) {
            start = head;
            end = head;
        } else {
            head.next = start;
            start = head;
        }
    }

    int len(ListNode head) {
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
}
