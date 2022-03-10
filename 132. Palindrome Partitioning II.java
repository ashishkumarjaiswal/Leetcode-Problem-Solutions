class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1])
                        dp[i][j] = true;
                }
            }
        }

        int[] ansdp = new int[n];

        for (int i = 1; i < n; i++) {
            if (dp[0][i]) {
                ansdp[i] = 0;
                continue;
            }

            int min = Integer.MAX_VALUE;
            for (int j = i; j > 0; j--) {
                if (dp[j][i]) {
                    if (ansdp[j - 1] < min)
                        min = ansdp[j - 1];
                }
            }
            ansdp[i] = min + 1;
        }

        return ansdp[n - 1];
    }
}
