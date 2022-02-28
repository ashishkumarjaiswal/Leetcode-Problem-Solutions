class Solution {
    public int dominantIndex(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(nums);
        int largest = nums[nums.length - 1];

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] * 2 > largest)
                return -1;
        }

        for (int i = 0; i < copy.length; i++) {
            if (copy[i] == largest)
                return i;
        }
        return 0;
    }
}
