class Solution {
    public int minPathSum(int[][] grid) {
        int len = grid.length;
        int width = grid[0].length;
        int[][] arr = new int[len][width];
        return fun(grid, arr, 0, 0);
    }

    public int fun(int[][] grid, int[][] arr, int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            arr[i][j] = grid[i][j];
            return grid[i][j];
        }

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return -1;
        }

        if (arr[i][j] != 0) {
            return arr[i][j];
        }

        int x =  fun(grid, arr, i + 1, j);
        int y =  fun(grid, arr, i, j + 1);
        if (x == -1 || y == -1) {
            arr[i][j] = Math.max(x, y)+grid[i][j];
        } else {
            arr[i][j] = Math.min(x, y)+grid[i][j];
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            arr[i][j] = grid[i][j];
        }
        return arr[i][j];
    }
}
