class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int[] is : dp) {
            Arrays.fill(is, Integer.MAX_VALUE);
        }
        return fun(triangle, 0, 0, dp);
    }

    public int fun(List<List<Integer>> triangle, int i, int j, int[][] dp) {
        if (i == triangle.size() - 1)
            return dp[i][j] = triangle.get(i).get(j);
        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }
        return dp[i][j] = triangle.get(i).get(j)
                + Math.min(fun(triangle, i + 1, j, dp), fun(triangle, i + 1, j + 1, dp));
    }
}
//Another one
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] dp = new Integer[triangle.size()][triangle.size()];
        return fun(triangle, dp, 0, 0);
    }

    int fun(List<List<Integer>> triangle, Integer[][] dp, int i, int j) {
        if (i >= triangle.size()) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        dp[i][j] = Math.min(fun(triangle, dp, i + 1, j), fun(triangle, dp, i + 1, j + 1)) + triangle.get(i).get(j);
        return dp[i][j];
    }
}
