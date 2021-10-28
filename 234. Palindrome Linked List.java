class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
        int s = 0, e = arr.size() - 1;
        while (s < e) {
            if (arr.get(s) != arr.get(e))
                return false;
            s++;
            e--;
        }
        return true;
    }
}
