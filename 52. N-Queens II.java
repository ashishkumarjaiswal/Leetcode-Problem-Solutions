class Solution {
    int arr[][];
    int count = 0;

    public int totalNQueens(int n) {
        arr = new int[n][n];
        fun(n, 0);
        return count;
    }

    boolean fun(int n, int i) {
        if (i == n) {
            count++;
            return true;
        }

        for (int j = 0; j < n; j++) {
            if (isValid(i, j)) {
                arr[i][j] = 1;
                fun(n, i + 1);
                arr[i][j] = 0;
            }
        }
        return false;
    }

    boolean isValid(int x, int y) {
        for (int i = x - 1; i >= 0; i--) {
            if (arr[i][y] == 1)
                return false;
        }
        for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 1)
                return false;
        }
        for (int i = x, j = y; i >= 0 && j < arr.length; i--, j++) {
            if (arr[i][j] == 1)
                return false;
        }
        return true;
    }
}
