//Method 1
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


//Method 2
class Solution {
    public void rotate(int[] nums, int k) {
        if (k == 0)
            return;
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    void reverse(int nums[], int s, int e) {
        while (s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }
}
