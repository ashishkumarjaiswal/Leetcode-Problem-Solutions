class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0)
            return head;
        ListNode root = head;
        int x = 0;
        while (root.next != null) {
            x++;
            root = root.next;
        }
        x++;
        root.next=head;
        k = x - k % x;
        root=head;
        while (k > 1) {
            k--;
            root = root.next;
        }
        head = root.next;
        root.next = null;
        return head;
    }
}
