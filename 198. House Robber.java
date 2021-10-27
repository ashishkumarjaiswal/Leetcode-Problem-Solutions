class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        } else if (n == 3) {
            return (nums[0] + nums[2]) > nums[1] ? nums[0] + nums[2] : nums[1];
        }
        arr[n - 1] = nums[n - 1];
        arr[n - 2] = nums[n - 2];
        arr[n - 3] = nums[n - 3] + nums[n - 1];

        for (int i = n - 4; i >= 0; i--) {
            if (arr[i + 2] > arr[i + 3])
                arr[i] = nums[i] + arr[i + 2];
            else
                arr[i] = nums[i] + arr[i + 3];
        }
        return arr[0]>arr[1]?arr[0]:arr[1];
    }
}
