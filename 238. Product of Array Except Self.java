class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];
        l[0] = nums[0];
        for (int i = 1; i < r.length; i++) {
            l[i] = nums[i] * l[i - 1];
        }
        r[r.length - 1] = nums[r.length - 1];
        for (int i = r.length - 2; i >= 0; i--) {
            r[i] = nums[i] * r[i + 1];
        }
        int[] ans = new int[nums.length];
        ans[0] = r[1];
        for (int i = 1; i < ans.length - 1; i++) {
            ans[i] = l[i - 1] * r[i + 1];
        }
        ans[ans.length - 1] = l[ans.length - 2];
        return ans;
    }
}
