//By Using Hashset
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head))
                return true;
            head = head.next;
        }
        return false;
    }
}

//Using two pointer
