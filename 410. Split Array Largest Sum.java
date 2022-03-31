class Solution {
    public int splitArray(int[] nums, int m) {
        int max = 0, sum = 0;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            sum = sum + nums[i];
        }

        int start = max, end = sum;
        if (m == nums.length)
            return max;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (fun(nums, mid, m)) {
                end = mid - 1;
                ans = mid;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    boolean fun(int[] arr, int mid, int size) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum > mid) {
                count++;
                sum = arr[i];
            }
        }
        return count <= size;
    }
}
