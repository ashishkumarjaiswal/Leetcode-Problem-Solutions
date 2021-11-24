class NumMatrix {
    int[][] mat;
    int[][] dp;

    public NumMatrix(int[][] matrix) {
        mat = matrix;
        dp = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = matrix[i][j];
                    continue;
                }
                dp[i][j] = dp[i][j - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = 0;
        for (int i = row1; i <= row2; i++) {
            if (col1 == 0) {
                total = total + dp[i][col2];
                continue;
            }
            total = total + dp[i][col2] - dp[i][col1 - 1];
        }
        return total;
    }
}
