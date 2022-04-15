class Solution {
    public int maxChunksToSorted(int[] arr) {
        int ans = 0;
        int n = arr.length;
        int leftMax[] = new int[n + 1];
        int rightMin[] = new int[n + 1];

        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        rightMin[n] = arr[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
        }

        for (int i = 0; i < n - 1; i++) {
            if (leftMax[i] <= rightMin[i + 1])
                ans++;
        }

        ans++;
        return ans;
    }
}
