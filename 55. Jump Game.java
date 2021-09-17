class Solution {
    public boolean canJump(int[] nums) {
        boolean[] ashish = new boolean[nums.length];
        ashish[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            int x = nums[i];
            int y = 1;
            while (x > 0) {
                if ((i + y) < nums.length && ashish[i + y] == true) {
                    ashish[i] = true;
                    break;
                }
                x--;
                y++;
            }
        }
        if (ashish[0] == true)
            return true;
        return false;
    }
}
