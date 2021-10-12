class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int count = 0;
        int top = 0, bot = n-1, left = 0, right = n-1;
        while (count < n * n) {
            for (int i = left; i <= right; i++) {
                count++;
                ans[top][i] = count;
            }
            top++;

            for (int i = top; i <= bot; i++) {
                count++;
                ans[i][right] = count;
            }
            right--;
            for (int i = right; i >= left; i--) {
                count++;
                ans[bot][i] = count;
            }
            bot--;
            for (int i = bot; i >= top; i--) {
                count++;
                ans[i][left] = count;
            }
            left++;
        }
        return ans;
    }
}
