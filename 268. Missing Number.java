class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            size = size + i + 1;
        }
        return size - sum;
    }
}
