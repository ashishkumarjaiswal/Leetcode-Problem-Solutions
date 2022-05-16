class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });
        int ans = 0;

        int[][] dir = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 },
                { 1, 1 }
        };

        while (!q.isEmpty()) {
            int size = q.size();
            ans++;

            for (int i = 0; i < size; i++) {
                int[] arr = q.poll();

                int x = arr[0];
                int y = arr[1];

                if (x == n - 1 && y == n - 1)
                    return ans;

                for (int[] temp : dir) {
                    int a = temp[0] + x;
                    int b = temp[1] + y;

                    if (!isValid(n, a, b))
                        continue;

                    if (grid[a][b] == 1)
                        continue;

                    grid[a][b] = 1;

                    q.add(new int[] { a, b });
                }
            }
        }
        return -1;
    }

    boolean isValid(int n, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= n)
            return false;

        return true;
    }
}
