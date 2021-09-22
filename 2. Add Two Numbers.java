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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry = 0;
        ListNode l3 = new ListNode();
        ListNode ashish=l3;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                int s=carry+l2.val;
                int k=s%10;
                carry=s/10;
                l3.next = new ListNode(k);
                l2 = l2.next;
                l3 = l3.next;
            } else if (l2 == null) {
                int s=carry+l1.val;
                int k=s%10;
                carry=s/10;
                l3.next = new ListNode(k);
                l3 = l3.next;
                l1 = l1.next;
            } else {
                int j = l1.val + l2.val + carry;
                int k = j % 10;
                carry = j / 10;
                l3.next = new ListNode(k);
                l3 = l3.next;
                l2 = l2.next;
                l1 = l1.next;
            }
        }
        if(carry!=0){
            l3.next=new ListNode(carry);
        }
        return ashish.next;
        
    }
}
