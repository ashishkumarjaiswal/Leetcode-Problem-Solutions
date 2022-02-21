class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int[][] ans = new int[image.length][image[0].length];
        for (int i = 0; i < ans.length; i++) {
            int k = image[0].length - 1;
            for (int j = 0; j < ans[0].length; j++) {
                ans[i][j] = image[i][k--] == 0 ? 1 : 0;
            }
        }
        return ans;
    }
}
