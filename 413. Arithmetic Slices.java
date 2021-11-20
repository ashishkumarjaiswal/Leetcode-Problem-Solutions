class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 2; i < nums.length; i++) {
            int x = nums[i] - nums[i - 1];
            int y = nums[i - 1] - nums[i - 2];
            if (x == y) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int total = 0;
        for (int i = 0; i < dp.length; i++) {
            total += dp[i];
        }
        return total;
    }
}
