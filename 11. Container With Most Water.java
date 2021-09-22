class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1;
        int total = Math.min(height[i], height[j]) * (j - i);
        while (i < j) {
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
            int max = Math.min(height[i], height[j]) * (j - i);
            if (max > total)
                total = max;
        }
        return total;
    }
}
