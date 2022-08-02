class Solution {
    boolean[][] visited;
    int ans = 0;

    public int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                fun(grid, i, j, 0);
            }
        }

        return ans;
    }

    int fun(int[][] grid, int i, int j, int curr) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
            return curr;
        }

        visited[i][j] = true;

        int left = fun(grid, i, j - 1, curr + grid[i][j]);
        int right = fun(grid, i, j + 1, curr + grid[i][j]);
        int up = fun(grid, i - 1, j, curr + grid[i][j]);
        int down = fun(grid, i + 1, j, curr + grid[i][j]);

        visited[i][j] = false;

        int max = Math.max(Math.max(left, right), Math.max(up, down));

        ans = Math.max(max, ans);

        return 0;
    }
}
