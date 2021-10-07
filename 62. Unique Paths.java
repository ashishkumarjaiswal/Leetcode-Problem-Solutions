class Solution {

    public int uniquePaths(int m, int n) {
        long count = 0;
        long[][] arr = new long[m][n];
        count = fun(m, n, 0, 0, count, arr);
        int x = (int) (count / 2);
        return x;
    }

    long fun(int m, int n, int i, int j, long count, long[][] arr) {
        if (i == m && j == n - 1 || i == m - 1 && j == n) {
            count++;
            return count;
        }
        if (i < 0 || j < 0 || i >= m || j >= n)
            return 0;

        if (arr[i][j] != 0) {
            count = arr[i][j];
            return count;
        }

        long x = fun(m, n, i, j + 1, count, arr) + fun(m, n, i + 1, j, count, arr);
        arr[i][j] = x;
        return x;
    }
}
