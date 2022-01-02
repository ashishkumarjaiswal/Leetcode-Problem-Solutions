class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        fun(nums, target, 0);
        return count;
    }

    int count = 0;

    void fun(int[] nums, int target, int start) {
        if (start == nums.length) {
            if (target == 0)
                count++;
            return;
        }
        fun(nums, target + nums[start], start + 1);
        fun(nums, target - nums[start], start + 1);
    }
}
