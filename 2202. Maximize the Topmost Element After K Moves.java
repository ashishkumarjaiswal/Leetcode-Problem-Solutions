class Solution {
    public int maximumTop(int[] nums, int k) {
        if (k % 2 == 1 && nums.length == 1)
            return -1;

        if (k == 1)
            return nums[1];

        if (k == 0)
            return nums[0];

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max)
                max = nums[i];

            k--;
            if (k == 1) {
                if (i == nums.length - 1) {
                    return max;
                }
                if (i + 2 < nums.length)
                    return Math.max(max, nums[i + 2]);
                return max;
            }
        }
        return max;
    }
}
