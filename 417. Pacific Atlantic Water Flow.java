class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] atlan = new boolean[m][n];
        boolean[][] pace = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, pace, i, 0, heights[i][0]);
            dfs(heights, atlan, i, n - 1, heights[i][n - 1]);
        }

        for (int i = 0; i < n; i++) {
            dfs(heights, pace, 0, i, heights[0][i]);
            dfs(heights, atlan, m - 1, i, heights[m - 1][i]);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (atlan[i][j] && pace[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }

        return ans;
    }

    void dfs(int[][] heights, boolean[][] arr, int i, int j, int prev) {
        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || arr[i][j] || prev > heights[i][j]) {
            return;
        }

        arr[i][j] = true;

        dfs(heights, arr, i, j + 1, heights[i][j]);
        dfs(heights, arr, i, j - 1, heights[i][j]);
        dfs(heights, arr, i + 1, j, heights[i][j]);
        dfs(heights, arr, i - 1, j, heights[i][j]);
    }
}
