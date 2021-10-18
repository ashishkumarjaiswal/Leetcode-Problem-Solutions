class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] arr = new List[nums.length + 1];
        for (int i : map.keySet()) {
            if (arr[map.get(i)] == null) {
                arr[map.get(i)] = new ArrayList<>();
            }
            arr[map.get(i)].add(i);
        }
        int[] ans = new int[k];
        int count = 0;
        for (int i = nums.length; i > 0; i--) {
            if (arr[i] != null) {
                for (int j = 0; j < arr[i].size() && count < k; j++) {
                    ans[count++] = arr[i].get(j);
                }
            }
            if (count == k)
                break;
        }
        return ans;
    }
}
