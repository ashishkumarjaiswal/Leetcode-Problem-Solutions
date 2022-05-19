class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        HashMap<String, Integer> map = new HashMap<>();
        boolean[][] arr = new boolean[m][n];

        for (int[] is : walls) {
            map.put(is[0] + " " + is[1], 1);
            arr[is[0]][is[1]] = true;
        }

        for (int[] is : guards) {
            map.put(is[0] + " " + is[1], 1);
            arr[is[0]][is[1]] = true;
        }

        for (int[] guard : guards) {
            int i = guard[0];
            int j = guard[1];

            int l = j - 1;
            int r = j + 1;
            int u = i - 1;
            int d = i + 1;

            while (l >= 0) {
                if (map.containsKey(i + " " + l)) {
                    break;
                } else {
                    arr[i][l] = true;
                }

                l--;
            }

            while (r < n) {
                if (map.containsKey(i + " " + r))
                    break;
                else
                    arr[i][r] = true;

                r++;
            }

            while (u >= 0) {
                if (map.containsKey(u + " " + j))
                    break;
                else
                    arr[u][j] = true;

                u--;
            }

            while (d < m) {
                if (map.containsKey(d + " " + j))
                    break;
                else
                    arr[d][j] = true;

                d++;
            }
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j])
                    count++;
            }
        }

        return m * n - count;
    }
}
