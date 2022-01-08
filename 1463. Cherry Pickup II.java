//Same Algorithm we can do in 2d array 
//apply same in the form of 3d array
class Solution {
    public int cherryPickup(int[][] grid) {
        Integer[][][] dp = new Integer[grid.length][grid[0].length][grid[0].length];
        return fun(grid, 0, 0, grid[0].length - 1, dp);
    }

    int fun(int[][] gird, int row, int col1, int col2, Integer[][][] dp) {
        if (row >= gird.length || col1 < 0 || col2 < 0 || col1 >= gird[0].length || col2 >= gird[0].length
                || col1 > col2) {
            return 0;
        }
        if (dp[row][col1][col2] != null)
            return dp[row][col1][col2];
        int max = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                max = Math.max(max, fun(gird, row + 1, col1 + i, col2 + j, dp));
            }
        }
        return dp[row][col1][col2] = max + gird[row][col1] + (col1 == col2 ? 0 : gird[row][col2]);
    }
}
