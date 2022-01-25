class NumArray {

    int arr[];
    int sum[];

    public NumArray(int[] nums) {
        arr = nums;
        sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0)
            return sum[right];
        return sum[right] - sum[left - 1];
    }
}
