class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        for (int i : nums) {
            min = Math.min(min, i);
        }

        int ans = 0;

        for (int i : nums) {
            ans = ans + i - min;
        }

        return ans;
    }
}
