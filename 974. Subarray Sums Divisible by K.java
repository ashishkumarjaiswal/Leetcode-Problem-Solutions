class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int[] psum = new int[n];
        psum[0] = nums[0];
        map.put(0, 1);

        for (int i = 1; i < n; i++) {
            psum[i] = psum[i - 1] + nums[i];
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            int rem = psum[i] % k;
            if (rem < 0)
                rem = rem + k;
            int x = map.getOrDefault(rem, 0);

            count = count + x;
            map.put(rem, x + 1);
        }
        return count;
    }
}
