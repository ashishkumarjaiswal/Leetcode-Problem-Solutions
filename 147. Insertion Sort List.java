class Solution {
    public ListNode insertionSortList(ListNode head) {
        // ListNode ans = new ListNode();
        ListNode result = new ListNode();
        if (head != null)
            result.val = head.val;
        head = head.next;
        while (head != null) {
            int temp = head.val;
            if (temp < result.val) {
                ListNode a = new ListNode(temp);
                a.next = result;
                result = a;
                head = head.next;
                continue;
            }
            ListNode x = result;
            while (x.next != null && x.next.val < temp) {
                x = x.next;
            }
            ListNode next = x.next;
            x.next = new ListNode(temp);
            x = x.next;
            x.next = next;

            head = head.next;
        }
        return result;
    }
}
