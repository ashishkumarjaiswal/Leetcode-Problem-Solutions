class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;
        int start = 0, end = 0, pro = 1, total = 0;

        while (end < nums.length) {
            pro = pro * nums[end];

            while (pro >= k) {
                pro = pro / nums[start++];
            }
            total = total + (end - start) + 1;
            end++;
        }
        return total;
    }
}
