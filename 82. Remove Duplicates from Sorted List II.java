
//Using TreeMap
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (head != null) {
            map.put(head.val, map.getOrDefault(head.val, 0) + 1);
            head = head.next;
        }
        ListNode ans = new ListNode();
        ListNode result = ans;
        for (int i : map.keySet()) {
            if (map.get(i) == 1) {
                ans.next = new ListNode(i);
                ans = ans.next;
            }
        }
        return result.next;
    }
}
