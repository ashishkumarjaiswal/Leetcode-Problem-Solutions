class Solution {
    public ListNode sortList(ListNode head) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        if (head == null)
            return head;
        while (head != null) {
            q.add(head.val);
            head = head.next;
        }
        ListNode ans = new ListNode(56);
        ListNode result = ans;
        while (!q.isEmpty()) {
            ans.next = new ListNode(q.poll());
            ans = ans.next;
        }
        return result.next;
    }
}

//Using merge sort
class Solution {
    public ListNode sortList(ListNode head) {
        return sort(head);
    }

    ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = middle(head);
        ListNode second = sort(middle.next);
        middle.next = null;
        ListNode first = sort(head);
        return merge(first, second);
    }

    ListNode merge(ListNode one, ListNode two) {
        ListNode ans = new ListNode(56);
        ListNode result = ans;
        while (one != null && two != null) {
            if (one.val > two.val) {
                ans.next = new ListNode(two.val);
                two = two.next;
            } else {
                ans.next = new ListNode(one.val);
                one = one.next;
            }
            ans = ans.next;
        }
        if (one != null) {
            ans.next = one;
        }
        if (two != null) {
            ans.next = two;
        }
        return result.next;
    }

    ListNode middle(ListNode head) {
        if (head == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
