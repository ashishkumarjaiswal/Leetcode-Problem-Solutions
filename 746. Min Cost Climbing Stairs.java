class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int min = Integer.MAX_VALUE;
        int n = cost.length;
        if (n == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int[] arr = new int[n];
        min = fun(arr, cost, n - 1);
        return min;
    }

    public int fun(int[] arr, int[] cost, int n) {
        if (n == 0) {
            arr[0] = cost[0];
            return cost[0];
        }
        if (n == 1) {
            return arr[1] = cost[1];
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        arr[n] = Math.min(fun(arr, cost, n - 1), fun(arr, cost, n - 2)) + cost[n];
        if (n == arr.length - 1) {
            return Math.min(arr[cost.length - 1], arr[cost.length - 2]);
        }
        return arr[n];
    }

}
