class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        long count = 0;
        int width = obstacleGrid[0].length;
        int len = obstacleGrid.length;
        long[][] arr = new long[len][width];
        count = fun(len, width, 0, 0, count, arr, obstacleGrid);
        int x = (int) (count / 2);
        return x;
    }

    long fun(int m, int n, int i, int j, long count, long[][] arr, int[][] obstacleGrid) {
        if (i == m && j == n - 1 || i == m - 1 && j == n) {
            count++;
            return count;
        }
        if (i < 0 || j < 0 || i >= m || j >= n || obstacleGrid[i][j] == 1)
            return 0;

        if (arr[i][j] != 0) {
            count = arr[i][j];
            return count;
        }

        long x = fun(m, n, i, j + 1, count, arr, obstacleGrid) + fun(m, n, i + 1, j, count, arr, obstacleGrid);
        arr[i][j] = x;
        return x;
    }
}
//Another one
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        Integer[][] dp = new Integer[m][n];
        return fun(m, n, dp, 0, 0, obstacleGrid);
    }

    int fun(int m, int n, Integer[][] dp, int i, int j, int[][] obstacleGrid) {
        if (i >= m || j >= n || obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        dp[i][j] = fun(m, n, dp, i + 1, j, obstacleGrid) + fun(m, n, dp, i, j + 1, obstacleGrid);
        return dp[i][j];
    }
}
