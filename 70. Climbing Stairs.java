class Solution {
    public int climbStairs(int n) {
        int arr[] = new int[n + 1];
        return fun(n, arr);
    }

    int fun(int n, int[] arr) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (arr[n] != 0)
            return arr[n];
        return arr[n] = fun(n - 1, arr) + fun(n - 2, arr);
    }
}
