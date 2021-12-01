class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int j = 1;
            int k = i - 1;
            int max = 0;
            while (k >= j) {
                if (dp[j] * dp[k] > max)
                    max = dp[j] * dp[k];
                if (dp[k] * j > max)
                    max = dp[k] * j;
                if (j * k > max)
                    max = j * k;
                k--;
                j++;
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
