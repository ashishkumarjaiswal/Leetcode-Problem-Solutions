class Solution {
    public int superPow(int a, int[] b) {
        int[] dp = new int[10];
        dp[0] = 1;
        a = a % 1337;

        for (int i = 1; i < 10; i++) {
            dp[i] = (dp[i - 1] * a) % 1337;
        }

        int ans = dp[b[0]];

        for (int i = 1; i < b.length; i++) {
            ans = findPow10(ans);
            ans = (ans * dp[b[i]]) % 1337;
        }

        return ans;
    }

    int findPow10(int a) {
        long ans = (a * a) % 1337;
        long temp = ans;

        ans = (ans * ans) % 1337;
        ans = (ans * ans) % 1337;
        ans = (ans * temp) % 1337;

        return (int) ans;
    }
}
