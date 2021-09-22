
class Solution {
    public void sortColors(int[] nums) {
        int one = 0, two = 0, zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                one++;
            if (nums[i] == 2)
                two++;
            if (nums[i] == 0)
                zero++;
        }
        int count = 0;
        while (count < nums.length) {
            while (zero > 0 && count < nums.length) {
                nums[count] = 0;
                count++;
                zero--;
            }
            while (one > 0 && count < nums.length) {
                nums[count] = 1;
                count++;
                one--;
            }
            while (two > 0 && count < nums.length) {
                nums[count] = 2;
                count++;
                two--;
            }
        }
    }
}
