class Solution {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        ListNode mid = findMid(head);

        TreeNode ans = new TreeNode(mid.val);

        if (head == mid)
            return ans;

        ans.left = sortedListToBST(head);
        ans.right = sortedListToBST(mid.next);

        return ans;
    }

    ListNode findMid(ListNode start) {
        if (start == null) {
            return start;
        }

        ListNode slow = start, fast = start, prev = start;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null)
            prev.next = null;

        return slow;
    }
}
