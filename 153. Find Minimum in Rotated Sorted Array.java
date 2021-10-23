class Solution {
    public int findMin(int[] nums) {
        int s = 0, e = nums.length - 1;
        if (nums[s] <= nums[e])
            return nums[0];
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] >= nums[mid + 1]) {
                return nums[mid+1];
            } else if (nums[mid] <= nums[mid - 1]) {
                return nums[mid ];
            } else if (nums[mid] >= nums[s]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return 0;
    }
}
