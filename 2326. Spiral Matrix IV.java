class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];

        for (int[] is : matrix) {
            Arrays.fill(is, -1);
        }

        int minr = 0, maxc = n - 1, minc = 0, maxr = m - 1;

        while (head != null) {
            for (int i = minr, j = minc; j <= maxc && head != null; j++) {
                matrix[i][j] = head.val;
                head = head.next;
            }
            minr++;

            for (int i = minr, j = maxc; i <= maxr && head != null; i++) {
                matrix[i][j] = head.val;
                head = head.next;
            }
            maxc--;

            for (int i = maxr, j = maxc; j >= minc && head != null; j--) {
                matrix[i][j] = head.val;
                head = head.next;
            }
            maxr--;

            for (int i = maxr, j = minc; i >= minr && head != null; i--) {
                matrix[i][j] = head.val;
                head = head.next;
            }
            minc++;
        }

        return matrix;
    }
}
