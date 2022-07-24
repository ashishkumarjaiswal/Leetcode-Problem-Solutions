class Solution {
    int[][] dp;

    public int countPaths(int[][] grid) {
        long ans = 0;
        dp = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = (ans + dfs(grid, i, j, 0)) % 1000000007;
            }
        }

        return (int) ans;
    }

    int dfs(int[][] grid, int i, int j, int prev) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 0;
        }

        if (prev >= grid[i][j])
            return 0;

        if (dp[i][j] != 0)
            return dp[i][j];

        dp[i][j] = 1;

        int a = dfs(grid, i + 1, j, grid[i][j]);
        int b = dfs(grid, i - 1, j, grid[i][j]);
        int c = dfs(grid, i, j + 1, grid[i][j]);
        int d = dfs(grid, i, j - 1, grid[i][j]);

        return dp[i][j] = (dp[i][j] + a + b + c + d) % 1000000007;
    }
}
