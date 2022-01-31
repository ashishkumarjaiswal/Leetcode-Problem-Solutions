class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] arr = nums.clone();
        int x = 1, y = nums.length - 1;

        for (int i = 0; i < arr.length; i++) {
            if (x >= nums.length) {
                x = 0;
            }
            nums[x] = arr[y--];
            x = x + 2;
        }
    }
}
