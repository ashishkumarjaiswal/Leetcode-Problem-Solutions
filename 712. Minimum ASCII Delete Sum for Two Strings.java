class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length() + 1, n = s2.length() + 1;
        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = 0;
                } else if (i == m - 1) {
                    dp[i][j] = dp[i][j + 1] + (int) s2.charAt(j);
                } else if (j == n - 1) {
                    dp[i][j] = dp[i + 1][j] + (int) s1.charAt(i);
                } else {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = Math.min(dp[i + 1][j] + s1.charAt(i), dp[i][j + 1] + s2.charAt(j));
                    }
                }
            }
        }

        return dp[0][0];
    }
}
