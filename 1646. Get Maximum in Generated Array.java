class Solution {
    public int getMaximumGenerated(int n) {
        int[] arr = new int[n + 1];
        int max = 0;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i / 2];
                if (arr[i] > max)
                    max = arr[i];
            } else {
                arr[i] = arr[i / 2] + arr[(i / 2) + 1];
                if (arr[i] > max)
                    max = arr[i];
            }
        }
        return max;
    }
}
