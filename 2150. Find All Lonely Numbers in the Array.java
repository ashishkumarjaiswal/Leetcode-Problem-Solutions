class Solution {
    public List<Integer> findLonely(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (Integer i : map.keySet()) {
            if (map.get(i) == 1) {
                if (!map.containsKey(i + 1) && !map.containsKey(i - 1))
                    ans.add(i);
            }
        }
        return ans;
    }
}
