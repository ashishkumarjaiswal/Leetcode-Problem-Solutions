class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int s = 0, e = nums.length - 1;
        for (int i = e; i >= 0; i--) {
            if (Math.abs(nums[s]) > Math.abs(nums[e])) {
                ans[i] = nums[s] * nums[s];
                s++;
            } else {
                ans[i] = nums[e] * nums[e];
                e--;
            }

        }
        return ans;
    }
}
