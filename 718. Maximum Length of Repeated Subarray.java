class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0 || nums1[i - 1] != nums2[j - 1]) {
                    continue;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }

        int ans = 0;

        for (int[] is : dp) {
            for (int i : is) {
                ans = Math.max(ans, i);
            }
        }

        return ans;
    }
}
