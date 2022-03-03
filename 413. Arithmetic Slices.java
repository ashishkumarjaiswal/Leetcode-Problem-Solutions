//Using Dp

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 2; i < nums.length; i++) {
            int x = nums[i] - nums[i - 1];
            int y = nums[i - 1] - nums[i - 2];
            if (x == y) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int total = 0;
        for (int i = 0; i < dp.length; i++) {
            total += dp[i];
        }
        return total;
    }
}
//Without Dp

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;

        if (nums.length < 3)
            return ans;

        int diff = nums[1] - nums[0];
        int count = 2;

        for (int i = 2; i < nums.length; i++) {
            while (i < nums.length && diff == nums[i] - nums[i - 1]) {
                count++;
                i++;
            }

            if (count >= 3) {
                int x = 0;
                int j = count - 2;
                while (j > 0) {
                    x = x + j;
                    j--;
                }
                ans = ans + x;
            }
            count = 2;
            diff = i < nums.length ? nums[i] - nums[i - 1] : 0;
        }
        return ans;
    }
}
