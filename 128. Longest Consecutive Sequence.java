class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, true);
        }
        for (int i : map.keySet()) {
            if (map.containsKey(i - 1))
                map.put(i, false);
        }
        int ans = 0;
        for (int i : map.keySet()) {
            if (map.get(i)) {
                int x = 1;
                while (map.containsKey(i + x)) {
                    x++;
                }
                ans = Math.max(ans, x);
            }
        }
        return ans;
    }
}
