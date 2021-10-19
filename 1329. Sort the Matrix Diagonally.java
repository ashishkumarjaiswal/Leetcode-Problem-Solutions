class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] arr = new int[m][n];
        for (int i = 0; i < n; i++) {
            PriorityQueue<Integer> q = new PriorityQueue<>();
            int k = 0;
            for (int j = i; j < n && k < m; j++, k++) {
                q.add(mat[k][j]);
            }
            k = 0;
            for (int j = i; j < n && k < m; j++, k++) {
                arr[k][j] = q.poll();
            }
        }
        for (int j = 0; j < m; j++) {
            PriorityQueue<Integer> q = new PriorityQueue<>();
            int k = 0;
            for (int i = j; i < m && k < n; i++, k++) {
                q.add(mat[i][k]);
            }
            k = 0;
            for (int i = j; i < m && k < n; i++, k++) {
                arr[i][k] = q.poll();
            }
        }
        return arr;
    }
}
