class Solution {
    public void gameOfLife(int[][] board) {
        int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };

        int row = board.length, col = board[0].length;
        int[][] copy = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                copy[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = 0;
                for (int k = 0; k < 8; k++) {
                    int a = i + x[k];
                    int b = j + y[k];
                    if (isValid(a, b, row, col)) {
                        if (copy[a][b] == 1) {
                            count++;
                        }
                    }
                }
                if (copy[i][j] == 1 && count < 2 || count > 3) {
                    board[i][j] = 0;
                }
                if (copy[i][j] == 0 && count == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    boolean isValid(int i, int j, int row, int col) {
        if (i < 0 || j < 0 || i >= row || j >= col)
            return false;
        return true;
    }
}
