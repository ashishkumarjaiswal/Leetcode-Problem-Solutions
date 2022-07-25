class Solution {
    boolean[][] visited;
    int[][] arr;

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        visited = new boolean[n][n];
        arr = new int[n][n];

        for (int[] is : dig) {
            int x = is[0];
            int y = is[1];

            visited[x][y] = true;
        }

        int ans = 0;

        for (int[] artifact : artifacts) {
            int sr = artifact[0];
            int sc = artifact[1];
            int er = artifact[2];
            int ec = artifact[3];

            if (dfs(sc, ec, sr, er, sr, sc))
                ans++;
        }

        return ans;
    }

    boolean dfs(int sc, int ec, int sr, int er, int i, int j) {
        if (i < sr || j < sc || i > er || j > ec || arr[i][j] == 1)
            return true;

        if (!visited[i][j])
            return false;

        arr[i][j] = 1;

        boolean a = dfs(sc, ec, sr, er, i + 1, j);
        boolean b = dfs(sc, ec, sr, er, i, j + 1);
        boolean c = dfs(sc, ec, sr, er, i - 1, j);
        boolean d = dfs(sc, ec, sr, er, i, j - 1);

        arr[i][j] = 0;

        return a && b && c && d;
    }
}
