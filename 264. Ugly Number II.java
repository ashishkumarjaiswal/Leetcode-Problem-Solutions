class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        int p2 = 1;
        int p3 = 1;
        int p5 = 1;

        for (int i = 2; i <= n; i++) {
            int m2 = 2 * dp[p2];
            int m3 = 3 * dp[p3];
            int m5 = 5 * dp[p5];

            int min = Math.min(Math.min(m2, m3), m5);

            dp[i] = min;

            if (min == m2){
                p2++;
            }
            if (min == m3){
                p3++;
            }
            if (min == m5){
                p5++;
            }
        }

        return dp[n];
    }
}
