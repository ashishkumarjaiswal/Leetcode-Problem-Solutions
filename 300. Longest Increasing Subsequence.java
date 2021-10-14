class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && cur < dp[j]) {
                    cur = dp[j];
                }
            }
            dp[i] = cur + 1;
            if (dp[i] > max)
                max = dp[i];
        }
        return max;
    }
}
