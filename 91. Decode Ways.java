class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        return fun(s, 0,dp);
    }

    int fun(String s, int i, int dp[]) {
        if (s.length() == i) {
            return 1;
        }
        if (s.charAt(i) == '0')
            return 0;
        if (s.length() - 1 == i) {
            return 1;
        }
        if (dp[i] != 0)
            return dp[i];
        int first = fun(s, i + 1, dp);
        int second = 0;
        if (Integer.parseInt(s.substring(i, i + 2)) <= 26) {
            second = fun(s, i + 2, dp);
        }
        return dp[i] = first + second;
    }
}
