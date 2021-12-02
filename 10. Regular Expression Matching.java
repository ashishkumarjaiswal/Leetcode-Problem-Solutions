class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        for (int i = 0; i <= p.length(); i++) {
            for (int j = 0; j <= s.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    if (p.charAt(i - 1) == '*') {
                        dp[i][j] = dp[i - 2][j];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (p.charAt(i - 1) == '*') {
                        if (p.charAt(i - 2) == '.') {
                            dp[i][j] = dp[i - 2][j] || dp[i][j - 1];

                        } else {
                            dp[i][j] = dp[i - 2][j];
                            if (p.charAt(i - 2) == s.charAt(j - 1)) {
                                dp[i][j] = dp[i][j] || dp[i][j - 1];
                            }
                        }
                    } else if (p.charAt(i - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        if (s.charAt(j - 1) == p.charAt(i - 1)) {
                            dp[i][j] = dp[i - 1][j - 1];
                        } else {
                            dp[i][j] = false;
                        }
                    }
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}
