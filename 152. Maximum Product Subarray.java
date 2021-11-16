class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int cp = 1;
        for (int i = 0; i < nums.length; i++) {
            cp *= nums[i];
            ans = Math.max(ans, cp);
            if (cp == 0) {
                cp = 1;
            }
        }
        cp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            cp *= nums[i];
            ans = Math.max(ans, cp);
            if (cp == 0) {
                cp = 1;
            }
        }
        return ans;
    }
}
