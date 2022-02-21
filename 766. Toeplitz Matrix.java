class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int g = 1; g < matrix[0].length; g++) {
            for (int i = 1, j = g; i < matrix.length && j < matrix[0].length; i++, j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1])
                    return false;
            }
        }
        for (int g = 1; g < matrix.length; g++) {
            for (int j = 1, i = g; i < matrix.length && j < matrix[0].length; i++, j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1])
                    return false;
            }
        }

        return true;
    }
}
