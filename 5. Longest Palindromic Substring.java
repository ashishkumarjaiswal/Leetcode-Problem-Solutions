class Solution {
    public String longestPalindrome(String s) {
        int l = s.length();
        boolean[][] dp = new boolean[l][l];
        int start = 0, end = 0;
        for (int g = 0; g < l; g++) {
            for (int i = 0, j = g; j < l; i++, j++) {
                if (g == 0) {
                    dp[i][i] = true;
                } else if (g == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        start = i;
                        end = j;
                    } else {
                        dp[i][j] = false;
                    }
                } else if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) {
                    dp[i][j] = true;
                    start = i;
                    end = j;
                } else {
                    dp[i][j] = false;
                }

            }
        }
        return s.substring(start, end + 1);
    }
}
