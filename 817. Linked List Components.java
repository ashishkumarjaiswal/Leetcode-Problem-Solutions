class Solution {
    public int numComponents(ListNode head, int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, 1);
        }

        int count = 0;
        int ans = 0;

        while (head != null) {
            int val = head.val;

            if (map.containsKey(val)) {
                count++;

                if (count == 1)
                    ans++;
            } else {
                count = 0;
            }

            head = head.next;
        }

        return ans;
    }
}
