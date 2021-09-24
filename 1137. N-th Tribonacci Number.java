class Solution {
    public int tribonacci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else if (n == 2)
            return 1;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 2; i < n; i++) {
            arr[i + 1] = arr[i] + arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
