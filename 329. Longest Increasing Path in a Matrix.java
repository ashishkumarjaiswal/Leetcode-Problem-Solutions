class Solution {
    int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m][n];
        int ans = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, fun(matrix, i, j));
            }
        }
        return ans;
    }

    int fun(int[][] matrix, int i, int j) {

        if (dp[i][j] != 0)
            return dp[i][j];

        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int ans = 1;

        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];

            if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length)
                continue;

            if (matrix[i][j] >= matrix[x][y])
                continue;

            ans = Math.max(ans, 1 + fun(matrix, x, y));
        }

        return dp[i][j] = ans;

    }
}
