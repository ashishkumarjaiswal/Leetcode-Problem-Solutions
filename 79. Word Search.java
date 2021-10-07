class Solution {
    boolean ashish = false;

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, word, i, j, 0);
                if (ashish)
                    return true;
            }

        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int count) {
        if (count == word.length()) {
            ashish = true;
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(count))
            return false;
        char temp = board[i][j];
        board[i][j] = '5';
        dfs(board, word, i + 1, j, count + 1);
        dfs(board, word, i - 1, j, count + 1);
        dfs(board, word, i, j + 1, count + 1);
        dfs(board, word, i, j - 1, count + 1);
        board[i][j] = temp;
        return false;
    }
}
