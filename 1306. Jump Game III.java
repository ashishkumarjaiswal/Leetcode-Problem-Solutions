class Solution {
    boolean[] dp;

    public boolean canReach(int[] arr, int start) {
        dp = new boolean[arr.length];
        return fun(arr, start);

    }

    boolean fun(int[] arr, int start) {
        if (start < 0 || start >= arr.length || dp[start]) {
            return false;
        }
        if (arr[start] == 0)
            return true;
        dp[start] = true;
        if (fun(arr, start + arr[start]) || fun(arr, start - arr[start])) {
            return true;
        }
        return false;
    }
}
