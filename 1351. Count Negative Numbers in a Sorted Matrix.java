class Solution {
    public int countNegatives(int[][] grid) {
        fun(grid, grid.length - 1, grid[0].length - 1);
        return count;
    }

    int count = 0;

    void fun(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || grid[i][j] >= 0) {
            return;
        }
        count++;
        grid[i][j] = 0;
        fun(grid, i - 1, j);
        fun(grid, i - 1, j - 1);
        fun(grid, i, j - 1);
    }
}
