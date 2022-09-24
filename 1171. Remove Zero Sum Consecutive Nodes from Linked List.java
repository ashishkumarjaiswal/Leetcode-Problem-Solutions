class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode curr = new ListNode(0);
        int sum = 0;

        curr.next = head;
        map.put(0, curr);

        while (curr != null) {
            sum = sum + curr.val;
            map.put(sum, curr);
            curr = curr.next;
        }

        curr = new ListNode(0);
        curr.next = head;
        sum = 0;
        head = curr;

        while (curr != null) {
            sum = sum + curr.val;
            ListNode x = map.get(sum);

            if (x != curr) {
                curr.next = x.next;
            }

            curr = curr.next;
        }

        return head.next;
    }
}
