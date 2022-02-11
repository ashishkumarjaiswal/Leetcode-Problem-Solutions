class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int ans = 0;
        int[] psum = new int[arr.length];
        psum[0] = arr[0];

        for (int i = 1; i < psum.length; i++) {
            psum[i] = psum[i - 1] + arr[i];
        }

        int count = 0;

        while (count < arr.length) {
            for (int i = count; i < psum.length; i++) {
                if (i - count - 1 < 0)
                    ans = ans + psum[i];
                else
                    ans = ans + psum[i] - psum[i - count - 1];
            }
            count = count + 2;
        }
        return ans;
    }
}
