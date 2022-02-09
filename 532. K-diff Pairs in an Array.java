class Solution {
    public int findPairs(int[] nums, int k) {
        int count = 0;
        if (nums.length == 1)
            return 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        if (k == 0) {
            for (Integer i : map.keySet()) {
                if (map.get(i) > 1)
                    count++;
            }
            return count;
        }

        for (int i : map.keySet()) {
            int x = i - k;
            if (map.containsKey(x))
                count++;
        }

        return count;
    }
}
