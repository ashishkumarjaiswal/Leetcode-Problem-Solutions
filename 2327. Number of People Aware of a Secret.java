class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long count = 0;
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            long share = dp[Math.max(0, i - delay)];
            long forgetSecret = dp[Math.max(0, i - forget)];
            count = (count + share - forgetSecret + mod) % mod;
            dp[i] = (int) count;
        }

        long ans = 0;

        for (int i = n - forget + 1; i <= n; i++) {
            ans = (ans + dp[i]) % mod;
        }

        return (int) ans;
    }
}
