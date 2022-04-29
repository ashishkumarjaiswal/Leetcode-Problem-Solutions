class Solution {
    public int snakesAndLadders(int[][] board) {
        int count = 0;
        int n = board.length;
        boolean[][] visited = new boolean[n][n];

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[n - 1][0] = true;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int x = q.poll();

                if (x == n * n)
                    return count;

                for (int j = 1; j < 7; j++) {
                    int k = x + j;

                    if (k > n * n)
                        break;

                    int[] temp = fun(n, k);
                    int r = temp[0];
                    int c = temp[1];

                    if (!visited[r][c]) {
                        visited[r][c] = true;

                        if (board[r][c] == -1) {
                            q.add(k);
                        } else {
                            q.add(board[r][c]);
                        }
                    }
                }
            }

            count++;
        }

        return -1;
    }

    int[] fun(int n, int k) {
        int r = n - (k - 1) / n - 1;
        int c = (k - 1) % n;

        if (r % 2 == n % 2) {
            return new int[] { r, n - 1 - c };
        } else {
            return new int[] { r, c };
        }
    }
}
