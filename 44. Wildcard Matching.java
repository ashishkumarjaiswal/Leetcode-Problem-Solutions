class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[p.length()][s.length()] = true;
        for (int i = p.length() - 1; i >= 0; i--) {
            dp[i][s.length()] = p.charAt(i) == '*' ? dp[i + 1][s.length()] : false;
        }
        for (int i = p.length() - 1; i >= 0; i--) {
            for (int j = s.length() - 1; j >= 0; j--) {
                switch (p.charAt(i)) {
                    case '?':
                        dp[i][j] = dp[i + 1][j + 1];
                        break;
                    case '*':
                        dp[i][j] = dp[i][j + 1] || dp[i + 1][j];
                        break;

                    default:
                        dp[i][j] = s.charAt(j) == p.charAt(i) ? dp[i + 1][j + 1] : false;
                        break;
                }
            }
        }
        return dp[0][0];
    }
}
