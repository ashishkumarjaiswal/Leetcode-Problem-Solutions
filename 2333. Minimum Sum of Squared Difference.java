class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int total = k1 + k2;
        int[] arr = new int[100001];

        for (int i = 0; i < n; i++) {
            arr[Math.abs(nums1[i] - nums2[i])]++;
        }

        for (int i = 100000; i > 0; i--) {
            if (arr[i] <= total) {
                arr[i - 1] += arr[i];
                total -= arr[i];
                arr[i] = 0;
            } else {
                arr[i - 1] += total;
                arr[i] -= total;
                break;
            }
        }

        long ans = 0;

        for (long i = 1; i < 100001; i++) {
            ans = ans + (i * i) * arr[(int) i];
        }

        return ans;
    }
}
