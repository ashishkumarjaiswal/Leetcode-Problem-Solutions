class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int x = 1;
            int biggest = Integer.MIN_VALUE, maxsum = Integer.MIN_VALUE;

            for (int j = i; j >= 0 && x <= k; j--, x++) {
                biggest = Math.max(biggest, arr[j]);
                maxsum = Math.max(maxsum, dp[i - x + 1] + x * biggest);
            }

            dp[i + 1] = maxsum;
        }

        return dp[n];
    }
}
