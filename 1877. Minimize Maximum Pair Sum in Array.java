class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        int max = 0;
        while (start < end) {
            if ((nums[start] + nums[end]) > max)
                max = nums[start] + nums[end];
            start++;
            end--;
        }
        return max;
    }
}
