740. Delete and Earn
class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] sum = new int[10001];
        if (nums.length == 1)
            return nums[0];

        for (int i = 0; i < nums.length; i++) {
            sum[nums[i]] += nums[i];
        }

        int[] dp = new int[10001];
        dp[10000] = sum[10000];
        dp[9999] = sum[9999];
        dp[9998] = sum[9998] + sum[10000];

        for (int i = 9997; i >= 0; i--) {
            if (dp[i + 2] > dp[i + 3]) {
                dp[i] = sum[i] + dp[i + 2];
            } else {
                dp[i] = sum[i] + dp[i + 3];
            }
        }
        return Math.max(dp[1], dp[0]);
    }
}
