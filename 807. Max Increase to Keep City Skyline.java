class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n][n];
        int count = 0;
        int total = 0;

        for (int[] is : grid) {
            for (int i : is) {
                total += i;
            }
        }

        for (int i = 0; i < n; i++) {
            int max = 0;

            for (int j = 0; j < n; j++) {
                max = Math.max(max, grid[i][j]);
            }

            for (int j = 0; j < n; j++) {
                ans[i][j] = max;
            }
        }

        for (int j = 0; j < n; j++) {
            int max = 0;

            for (int i = 0; i < n; i++) {
                max = Math.max(grid[i][j], max);
            }

            for (int i = 0; i < n; i++) {
                ans[i][j] = Math.min(max, ans[i][j]);
                count += ans[i][j];
            }
        }

        return count - total;
    }
}
