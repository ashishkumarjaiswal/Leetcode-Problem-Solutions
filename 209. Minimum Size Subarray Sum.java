class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int curr = 0;
        int min = Integer.MAX_VALUE;
        int start = 0, end = 0;
        while (end < nums.length) {
            while (end < nums.length && curr < target) {
                curr = curr + nums[end++];
            }

            while (curr >= target && start <= end) {
                min = Math.min(min, end - start);
                curr = curr - nums[start++];
            }

        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
