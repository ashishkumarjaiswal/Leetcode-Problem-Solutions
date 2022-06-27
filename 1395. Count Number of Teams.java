class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int[][] dp = new int[n][4];

        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rating[i] < rating[j]) {
                    dp[i][0]++;
                } else {
                    dp[i][1]++;
                }
            }

            for (int j = i - 1; j >= 0; j--) {
                if (rating[i] > rating[j]) {
                    dp[i][2]++;
                } else {
                    dp[i][3]++;
                }
            }
        }

        int ans = 0;

        for (int i = 1; i < n - 1; i++) {
            int mul = dp[i][0] * dp[i][2] + dp[i][1] * dp[i][3];
            ans += mul;
        }

        return ans;
    }
}
