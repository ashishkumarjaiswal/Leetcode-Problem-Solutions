class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] ans = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                ans[k] = nums2[j];
                j++;
            } else {
                ans[k] = nums1[i];
                i++;
            }
            k++;
        }
        while (i < nums1.length) {
            ans[k] = nums1[i];
            i++;
            k++;
        }
        while (j < nums2.length) {
            ans[k] = nums2[j];
            j++;
            k++;
        }
        if (len % 2 != 0)
            return (double) ans[len / 2];
        else {
            double a = (ans[len / 2] + ans[(len / 2) - 1]) / 2.0;
            System.out.println(a);
            return a;
        }
    }
}
