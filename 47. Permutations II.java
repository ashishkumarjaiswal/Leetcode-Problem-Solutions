class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        fun(nums, new ArrayList<>());
        return result;
    }

    void fun(int[] nums, List<Integer> curr) {
        if (curr.size() == nums.length) {
            result.add(curr);
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                continue;
            }
            if (nums[j] == 11)
                continue;
            curr.add(nums[j]);
            int temp = nums[j];
            nums[j] = 11;
            fun(nums, new ArrayList<>(curr));
            nums[j] = temp;
            curr.remove(curr.size() - 1);
        }
    }
}
