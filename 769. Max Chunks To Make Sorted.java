class Solution {
    public int maxChunksToSorted(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            for (int j = i + 1; j <= n; j++) {
                if (arr[j] > n)
                    n = arr[j];
            }
            count++;
            i = n;
        }
        return count;
    }
}
