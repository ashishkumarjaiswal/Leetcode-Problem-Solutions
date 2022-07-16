class Solution {
    HashMap<String, Long> map = new HashMap<>();

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long x = fun(m, n, maxMove, startRow, startColumn);

        return (int) x;
    }

    long fun(int m, int n, int maxMove, int i, int j) {

        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 1;
        }

        if (maxMove <= 0)
            return 0;

        String key = i + " " + j + " " + maxMove;

        if (map.containsKey(key)) {
            return map.get(key);
        }

        long ans = fun(m, n, maxMove - 1, i + 1, j) + fun(m, n, maxMove - 1, i - 1, j)
                + fun(m, n, maxMove - 1, i, j + 1) + fun(m, n, maxMove - 1, i, j - 1);

        ans = ans % 1000000007;

        map.put(key, ans);

        return ans;
    }
}
