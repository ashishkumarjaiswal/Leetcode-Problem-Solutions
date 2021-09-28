class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int odd = 1, even = 0;
        int[] ashish = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                ashish[even] = nums[i];
                even = even + 2;
            } else {
                ashish[odd] = nums[i];
                odd = odd + 2;
            }
        }
        return ashish;
    }
}
