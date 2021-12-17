class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = matrix[m - 1][i];
            max = Math.max(max, matrix[m - 1][i]);
        }
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = matrix[i][n - 1];
            max = Math.max(max, matrix[i][n - 1]);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (matrix[i][j] == 49) {
                    dp[i][j] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i + 1][j + 1]) + 1;
                    if (dp[i][j] > max)
                        max = dp[i][j];
                } else {
                    dp[i][j] = 48;
                }
            }
        }
        if (max == 0)
            return 0;
        max = max - 48;
        return max * max;
    }
}
//Another One
class Solution {
    Integer[][] dp;

    public int maximalSquare(char[][] matrix) {
        dp = new Integer[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length-1; j >= 0; j--) {
                if (matrix[i][j] != '0') {
                    if (i + 1 >= matrix.length || j + 1 >= matrix[0].length) {
                        dp[i][j] = 1;
                    } else
                        dp[i][j] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i + 1][j + 1]) + 1;
                } else {
                    dp[i][j] = 0;
                }
                if (dp[i][j] > max)
                    max = dp[i][j];
            }

        }
        return max*max;
    }
}
