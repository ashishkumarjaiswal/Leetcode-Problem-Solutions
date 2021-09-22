class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = { -1, -1 };
        int lo = 0;
        int hi = nums.length - 1;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                arr[0] = mid;
                hi = mid - 1;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        lo = 0;
        hi = nums.length - 1;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                arr[1] = mid;
                lo = mid + 1;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return arr;
    }
}
