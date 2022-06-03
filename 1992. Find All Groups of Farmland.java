class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> list = new LinkedList<>();

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    int[] arr = { i, j, 0, 0 };
                    dfs(land, i, j, arr);
                    list.add(arr);
                }
            }
        }

        return list.toArray(new int[0][]);
    }

    void dfs(int[][] land, int i, int j, int[] arr) {
        if (i >= land.length || j >= land[0].length || land[i][j] == 0)
            return;

        land[i][j] = 0;
        arr[2] = Math.max(i, arr[2]);
        arr[3] = Math.max(arr[3], j);

        dfs(land, i + 1, j, arr);
        dfs(land, i, j + 1, arr);
    }
}
