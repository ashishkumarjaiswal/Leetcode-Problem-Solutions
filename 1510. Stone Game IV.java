class Solution {
    HashMap<Integer, Boolean> map = new HashMap<>();

    public boolean winnerSquareGame(int n) {
        return fun(n);
    }

    boolean fun(int n) {
        if (n <= 0)
            return false;

        if (map.containsKey(n))
            return map.get(n);

        for (int i = 1; i * i <= n; i++) {
            if (!fun(n - i * i)) {
                map.put(n, true);
                return true;
            }
        }
        map.put(n, false);
        return false;
    }
}
