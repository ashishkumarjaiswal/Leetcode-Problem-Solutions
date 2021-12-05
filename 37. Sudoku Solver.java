class Solution {
    public void solveSudoku(char[][] board) {
        fun(board, 0, 0);
    }

    boolean fun(char[][] board, int i, int j) {
        if (i == 9)
            return true;
        int ni = 0;
        int nj = 0;
        if (j == 8) {
            ni = i + 1;
            nj = 0;
        } else {
            nj = j + 1;
            ni = i;
        }
        if (board[i][j] != '.') {
            return fun(board, ni, nj);
        } else {
            for (int k = 1; k <= 9; k++) {
                char c = (char) (k + '0');
                if (isValid(board, i, j, c)) {
                    board[i][j] = c;
                    if (fun(board, ni, nj))
                        return true;
                    else
                        board[i][j] = '.';

                }
            }
        }
        return false;
    }

    boolean isValid(char[][] board, int x, int y, char val) {
        for (int k = 0; k < 9; k++) {
            if (board[x][k] == val)
                return false;
        }
        for (int k = 0; k < 9; k++) {
            if (board[k][y] == val)
                return false;
        }
        int si = x / 3 * 3;
        int sj = y / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + si][j + sj] == val)
                    return false;
            }
        }
        return true;
    }
}
