class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length && i <= k; i++) {
            if (map.getOrDefault(nums[i], 0) != 0)
                return true;
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = k + 1; i < nums.length; i++) {
            if (map.get(nums[i - k - 1]) == 1)
                map.remove(nums[i - k - 1]);
            else
                map.put(nums[i - k - 1], map.get(nums[i - k - 1]) - 1);

            if (map.getOrDefault(nums[i], 0) != 0)
                return true;
            else
                map.put(nums[i], 1);
        }
        return false;
    }
}
