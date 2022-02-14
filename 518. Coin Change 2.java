class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < dp.length; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[dp.length - 1];
    }
}

//Another one

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
