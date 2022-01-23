class Solution {
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        boolean[] leftToRight = new boolean[nums.length];
        boolean[] rightToLeft = new boolean[nums.length];

        for (int i = 1; i < rightToLeft.length; i++) {
            if (nums[i - 1] < nums[i] || leftToRight[i - 1])
                leftToRight[i] = true;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i] || rightToLeft[i + 1])
                rightToLeft[i] = true;
        }

        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (rightToLeft[i] && leftToRight[i])
                count++;
        }
        return count;
    }
}
