class Solution {
    public int search(int[] nums, int target) {
        int s = 0, e = nums.length - 1, m = 0;
        while (s <= e) {
            m = (s + e) / 2;
            if (nums[m] == target)
                return m;
            else if (target > nums[m])
                s = m + 1;
            else
                e = m - 1;
        }
        return -1;
    }
}
