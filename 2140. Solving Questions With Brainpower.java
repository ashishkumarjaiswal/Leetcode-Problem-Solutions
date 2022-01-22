class Solution {
    public long mostPoints(int[][] questions) {
        long maxAns = questions[questions.length - 1][0];
        long[] dp = new long[questions.length];
        dp[dp.length - 1] = questions[questions.length - 1][0];
        for (int i = questions.length - 2; i >= 0; i--) {
            if (questions[i][1] + i + 1 >= dp.length) {
                dp[i] = Math.max(questions[i][0], dp[i + 1]);
                maxAns = Math.max(maxAns, dp[i]);
            } else {
                dp[i] = Math.max((questions[i][0] + dp[i + 1 + questions[i][1]]), dp[i + 1]);
                maxAns = Math.max(maxAns, dp[i]);
            }
        }
        return maxAns;
    }
}
