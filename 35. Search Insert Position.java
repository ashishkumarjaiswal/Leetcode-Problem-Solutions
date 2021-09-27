class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (target <= nums[0])
            return 0;
        if (target > nums[len - 1])
            return len;
        if (target == nums[len - 1])
            return len-1;
        int start = 0, end = len, mid = 0;
        while (start < end) {
            mid = (start + end) / 2;
            if (target == nums[mid])
                return mid;
            else if (target < nums[mid])
                end = mid;
            else
                start = mid;
            if ((end - start) == 1)
                return end;
        }
        return 0;
    }
}
