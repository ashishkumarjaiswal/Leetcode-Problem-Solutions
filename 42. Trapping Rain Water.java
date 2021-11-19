class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] right = new int[n];
        int[] left = new int[n];
        right[0] = height[0];
        int max = height[0];
        for (int i = 1; i < n; i++) {
            if (height[i] > max) {
                max = height[i];
                right[i] = max;
            } else {
                right[i] = max;
            }
        }
        max = height[n - 1];
        left[n - 1] = max;
        for (int i = n - 2; i >= 0; i--) {
            if (height[i] > max) {
                max = height[i];
                left[i] = max;
            } else {
                left[i] = max;
            }
        }
        int total = 0;
        for (int i = 0; i < left.length; i++) {
            total = total + Math.min(right[i], left[i])-height[i];
        }
        return total;
    }
}
