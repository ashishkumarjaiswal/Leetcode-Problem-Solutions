class Solution {
    Integer[] dp;

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        dp = new Integer[target + 1];
        dp[0] = 1;
        return fun(nums, target);
    }

    int fun(int[] nums, int target) {
        if (dp[target] != null) {
            return dp[target];
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                count = count + fun(nums, target - nums[i]);
            }
        }
        return dp[target] = count;
    }
}
