class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = grid[m - 1][i];
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;

                for (int k = 0; k < n; k++) {
                    min = Math.min(min, dp[i + 1][k] + moveCost[grid[i][j]][k]);
                }

                dp[i][j] = min + grid[i][j];
            }
        }
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[0][i]);
        }

        return ans;
    }
}
