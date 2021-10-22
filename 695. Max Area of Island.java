class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int x = fun(grid, i, j);
                if (x > max)
                    max = x;
            }
        }
        return max;
    }

    int fun(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
            return 0;
        int max = 0;
        max++;
        grid[i][j] = 0;
        max = max + fun(grid, i + 1, j);
        max = max + fun(grid, i - 1, j);
        max = max + fun(grid, i, j + 1);
        max = max + fun(grid, i, j - 1);
        return max;
    }
}
