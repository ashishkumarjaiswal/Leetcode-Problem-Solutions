class Solution {
    public int minStartValue(int[] nums) {
        int total = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            total = total + nums[i];
            if (total < 1) {
                int x = 1 - total;
                start = x + start;
                total = total + x;
            }
        }
        if (start == 0) {
            return 1;
        }
        return start;
    }
}
