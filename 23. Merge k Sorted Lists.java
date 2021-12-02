class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int s, int e) {
        if (s == e)
            return lists[s];
        int mid = (s + e) / 2;
        ListNode a = mergeKLists(lists, s, mid);
        ListNode b = mergeKLists(lists, mid + 1, e);
        return mergeTwoList(a, b);
    }

    ListNode mergeTwoList(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        ListNode ans = new ListNode(56);
        ListNode result = ans;

        while (a != null && b != null) {
            if (a.val < b.val) {
                ans.next = a;
                a = a.next;
            } else {
                ans.next = b;
                b = b.next;
            }
            ans = ans.next;
        }
        ans.next = a == null ? b : a;
        return result.next;
    }
}
