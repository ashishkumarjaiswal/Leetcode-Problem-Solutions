class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Integer[][] dp = new Integer[m][n + 1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            dp[m - 1][i] = matrix[m - 1][i];
        }
        for (int i = 0; i < matrix.length; i++) {
            int x = fun(matrix, dp, 0, i);
            if (x < min)
                min = x;
        }
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return min;
    }

    int fun(int[][] matrix, Integer[][] dp, int i, int j) {
        if (j < 0 || j >= matrix[0].length) {
            return 100000;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int a = fun(matrix, dp, i + 1, j);
        int b = fun(matrix, dp, i + 1, j + 1);
        int c = fun(matrix, dp, i + 1, j - 1);
        int ashish = Math.min(a, b);
        dp[i][j] = matrix[i][j] + Math.min(ashish, c);
        return dp[i][j];
    }
}
