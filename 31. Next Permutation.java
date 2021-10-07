class Solution {
    public void nextPermutation(int[] nums) {
        int count = 0, i;
        if (nums.length == 1)
            return;
        boolean ashish = true;
        for (i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                count = i;
                ashish = false;
                break;
            }
        }
        if (ashish) {
            int p = 0, q = nums.length - 1;
            while (p < q) {
                int tem = nums[p];
                nums[p] = nums[q];
                nums[q] = tem;
                p++;
                q--;
            }
            return;
        }
        // if (i == 0) {
        // int temp = nums[nums.length - 1];
        // nums[nums.length - 1] = nums[nums.length - 2];
        // nums[nums.length - 2] = temp;
        // return;
        // }
        int x = i;
        for (int j = i; j < nums.length; j++) {
            if (nums[j] > nums[count - 1] && nums[j] < nums[x])
                x = j;
        }
        int temp = nums[x];
        nums[x] = nums[i - 1];
        nums[i - 1] = temp;
        Arrays.sort(nums, i, nums.length);
        
    }
}
