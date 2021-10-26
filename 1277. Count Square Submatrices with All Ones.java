class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0)
                    continue;
                else if (j == 0 || i == 0) {
                    result = matrix[i][j] + result;
                    continue;
                } else {
                    int x = Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]);
                    matrix[i][j] = x + 1;
                }
                result = matrix[i][j] + result;
            }
        }
        return result;
    }
}
