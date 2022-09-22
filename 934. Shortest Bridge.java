class Solution {
    Queue<int[]> q = new LinkedList<>();

    public int shortestBridge(int[][] grid) {
        boolean flag = false;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fixOne(grid, i, j);
                    flag = true;
                    break;
                }
            }

            if (flag)
                break;
        }

        int count = 0;

        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] x = q.poll();

                for (int[] dir : dirs) {
                    int a = dir[0] + x[0];
                    int b = dir[1] + x[1];

                    if (isValid(grid, a, b)) {
                        if (grid[a][b] == 1)
                            return count;

                        q.add(new int[] { a, b });
                        grid[a][b] = -1;
                    }
                }
            }

            count++;
        }

        return count;
    }

    boolean isValid(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1)
            return false;

        return true;
    }

    void fixOne(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || grid[i][j] == 2)
            return;

        grid[i][j] = 2;
        q.add(new int[] { i, j });

        fixOne(grid, i + 1, j);
        fixOne(grid, i - 1, j);
        fixOne(grid, i, j + 1);
        fixOne(grid, i, j - 1);
    }
}
