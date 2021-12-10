class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0)
            return false;
        boolean[][] ans = new boolean[nums.length + 1][(sum / 2) + 1];
        for (int i = 0; i <= (sum / 2); i++) {
            ans[0][i] = false;
        }
        for (int i = 0; i <= nums.length; i++) {
            ans[i][0] = true;
        }
        for (int i = 1; i < ans.length; i++) {
            for (int j = 1; j < ans[0].length; j++) {
                if (ans[i - 1][j] == true) {
                    ans[i][j] = true;
                } else {
                    int val = nums[i - 1];
                    if (j >= val && ans[i - 1][j - val]) {
                        ans[i][j] = true;
                    }
                }
            }
        }
        return ans[ans.length - 1][ans[0].length - 1];
    }
}
