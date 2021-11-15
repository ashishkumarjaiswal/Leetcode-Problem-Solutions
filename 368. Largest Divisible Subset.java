class Solution {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        fun(nums, 0, new ArrayList<>(), 1);
        return ans;
    }

    boolean ashish = false;

    void fun(int[] nums, int ind, List<Integer> list, int prev) {
        if (ashish)
            return;
        if (list.size() > ans.size()) {
            ans = new ArrayList<>(list);
            if (ans.size() == nums.length) {
                ashish = true;
            }
        }
        for (int i = ind; i < nums.length; i++) {
            if (nums[i] % prev == 0) {
                list.add(nums[i]);
                fun(nums, i + 1, list, nums[i]);
                list.remove(list.size() - 1);
            }
        }
    }
}
