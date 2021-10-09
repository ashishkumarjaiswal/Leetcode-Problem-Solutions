class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = k - 1; i < nums.length; i++) {
            if (nums[i] - nums[i - k + 1] < min)
                min = nums[i] - nums[i - k + 1];
        }
        return min;
    }
}
