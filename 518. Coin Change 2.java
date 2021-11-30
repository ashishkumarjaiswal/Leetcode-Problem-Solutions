class Solution {
    public int change(int amount, int[] coins) {
        HashMap<String, Integer> map = new HashMap<>();
        return fun(amount, coins, 0, map);
    }

    int fun(int amount, int[] coins, int i, HashMap<String, Integer> map) {
        if (amount < 0 || i >= coins.length) {
            return 0;
        }
        if (amount == 0) {
            return 1;
        }
        String key = i + " " + amount;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int ans = 0;
        for (int j = i; j < coins.length; j++) {
            if (amount >= coins[j])
                ans = ans + fun(amount - coins[j], coins, j, map);
        }
        map.put(key, ans);
        return ans;
    }
}
