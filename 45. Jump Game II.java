class Solution {
    public int jump(int[] nums) {
        int[] ashish = new int[nums.length];
        ashish[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int min = 99999;
            if (nums[i] == 0) {
                ashish[i] = min;
                continue;
            }
            int x = nums[i];
            int y = 1;
            while (x > 0) {
                if ((i + y) < nums.length && ashish[i + y] < min) {
                    min = ashish[i + y];
                }
                x--;
                y++;
            }
            if (min == 99999)
                ashish[i] = min;
            else
                ashish[i] = min + 1;

        }
        return ashish[0];
    }
}
