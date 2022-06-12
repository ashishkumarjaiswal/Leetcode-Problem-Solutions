class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int max = 0, curr = 0;
        HashSet<Integer> set = new HashSet<>();
        int i = 0, j = 0;

        while (j < nums.length) {
            while (j < nums.length && !set.contains(nums[j])) {
                set.add(nums[j]);
                curr = curr + nums[j];
                j++;
            }

            max = Math.max(max, curr);

            curr = curr - nums[i];
            set.remove(nums[i]);
            i++;
        }

        return max;
    }
}
