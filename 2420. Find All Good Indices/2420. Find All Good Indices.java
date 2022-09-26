class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 1; i < right.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                right[i] = right[i-1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i + 1] >= nums[i]) {
                left[i] = left[i+1] + 1;
            }
        }

        for (int i = 1; i < n - 1; i++) {
            if (left[i + 1]+1 >= k && right[i - 1]+1 >= k)
                ans.add(i);
        }

       

        return ans;
    }
}
