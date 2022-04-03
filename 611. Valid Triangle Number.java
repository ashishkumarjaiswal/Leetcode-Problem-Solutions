class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);

        for (int i = nums.length - 1; i > 0; i--) {
            int l = 0, r = i - 1;

            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    count = count + (r - l);
                    r--;
                } else {
                    l++;
                }
            }
        }
        return count;
    }
}
