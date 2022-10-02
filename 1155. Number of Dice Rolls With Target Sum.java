class Solution {
    Integer[][] dp;

    public int numRollsToTarget(int n, int k, int target) {
        dp = new Integer[n + 1][target + 1];
        return fun(n, k, target);
    }

    int fun(int n, int k, int target) {
        if (n == 0) {
            if (target == 0) {
                return 1;
            }

            return 0;
        }

        if (target < 0)
            return 0;

        if (dp[n][target] != null) {
            return dp[n][target];
        }

        int count = 0;

        for (int i = 1; i <= k; i++) {
            count = (count + fun(n - 1, k, target - i)) % 1000000007;
        }

        dp[n][target] = count;

        return count;
    }
}
