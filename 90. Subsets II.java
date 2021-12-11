class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        fun(nums, 0, new ArrayList<>());
        return result;
    }

    void fun(int[] nums, int ind, List<Integer> list) {
        result.add(new ArrayList<>(list));
        for (int i = ind; i < nums.length; i++) {
            if (i > ind && nums[i - 1] == nums[i])
                continue;
            list.add(nums[i]);
            fun(nums, i + 1, new ArrayList<>(list));
            list.remove(list.size() - 1);
        }
    }
}
