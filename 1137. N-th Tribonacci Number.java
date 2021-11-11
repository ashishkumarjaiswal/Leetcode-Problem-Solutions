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
//Another one
class Solution {
    public int tribonacci(int n) {
        int arr[] = new int[n + 1];
        return tib(n, arr);
    }

    int tib(int n, int[] arr) {
        if (n == 0)
            return arr[0] = 0;
        if (n == 1 ||n == 2)
            return arr[1] = 1;
        if (arr[n] != 0)
            return arr[n];
        return arr[n] = tib(n - 1, arr) + tib(n - 2, arr) + tib(n - 3, arr);
    }
}
