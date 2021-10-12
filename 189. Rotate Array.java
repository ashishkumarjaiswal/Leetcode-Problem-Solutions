class Solution {
    public void rotate(int[] nums, int k) {
        int count = 0, len = nums.length;
        int[] ans = new int[len];
        ans = nums.clone();
        k = k % len;
        int x = k;
        for (int i = 0; i < len; i++) {
            nums[(x + i) % len] = ans[count];
            count++;
        }
    }
}
