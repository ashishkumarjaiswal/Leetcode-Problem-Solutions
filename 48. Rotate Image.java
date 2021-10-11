class Solution {
    public void rotate(int[][] matrix) {
        trans(matrix);
        rotat(matrix);
    }

    public void trans(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void rotat(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int s = 0, l = matrix.length - 1;
            while (s < l) {
                int temp = matrix[i][s];
                matrix[i][s] = matrix[i][l];
                matrix[i][l] = temp;
                s++;
                l--;
            }
        }
    }
}
