/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode a = new ListNode();
        ListNode b = a;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                a.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                a.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            a = a.next;
        }
        while (l1 != null) {
            a.next = new ListNode(l1.val);
            l1 = l1.next;
            a = a.next;
        }
        while (l2 != null) {
            a.next = new ListNode(l2.val);
            l2 = l2.next;
            a = a.next;
        }
        return b.next;
    }
}
