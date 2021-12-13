class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int dp[][] = new int[dungeon.length][dungeon[0].length];
        int ans = fun(dungeon, dp, 0, 0);
        return ans;
    }

    int fun(int[][] dungeon, int[][] dp, int i, int j) {
        if (i >= dungeon.length || j >= dungeon[0].length) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][j] != 0)
            return dp[i][j];
        int min = Math.min(fun(dungeon, dp, i + 1, j), fun(dungeon, dp, i, j + 1));
        if (min == Integer.MAX_VALUE)
            min = 1;
        int x = min - dungeon[i][j];
        // System.out.println(i + " " + j + " " + x);
        if (x <= 0) {
            dp[i][j] = 1;
        } else {
            dp[i][j] = x;
        }
        return dp[i][j];
    }
}
