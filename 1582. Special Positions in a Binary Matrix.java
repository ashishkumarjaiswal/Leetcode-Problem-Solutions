class Solution {
    public int numSpecial(int[][] mat) {
        int count = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    if (check(mat, i, j))
                        count++;
                }
            }
        }

        return count;
    }

    boolean check(int[][] mat, int x, int y) {
        for (int i = 0; i < mat.length; i++) {
            if (i == x)
                continue;

            if (mat[i][y] == 1)
                return false;
        }

        for (int j = 0; j < mat[0].length; j++) {
            if (j == y)
                continue;

            if (mat[x][j] == 1)
                return false;
        }

        return true;
    }
}
