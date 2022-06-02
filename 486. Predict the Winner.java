class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; i < n && j < n; i++, j++) {
                if (g == 0) {
                    dp[i][j] = nums[i];
                } else if (g == 1) {
                    dp[i][j] = Math.max(nums[i], nums[j]);
                } else {
                    int x = nums[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
                    int y = nums[j] + Math.min(dp[i][j - 2], dp[i + 1][j - 1]);
                    dp[i][j] = Math.max(x, y);
                }
            }
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            total = total + nums[i];
        }

        return total - dp[0][n - 1] <= dp[0][n - 1];
    }
}
