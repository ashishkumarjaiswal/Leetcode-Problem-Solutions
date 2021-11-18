class Solution {
    public int maxProfit(int[] prices, int fee) {
        HashMap<String, Integer> map = new HashMap<>();
        return fun(0, 0, prices, map, fee);
    }

    int fun(int pos, int buyOrSell, int[] prices, HashMap<String, Integer> map, int fee) {
        if (pos >= prices.length)
            return 0;
        if (map.containsKey(pos + " " + buyOrSell)) {
            return map.get(pos + " " + buyOrSell);
        }
        int x = 0;
        if (buyOrSell == 0) {
            int buy = fun(pos + 1, 1, prices, map, fee) - prices[pos] - fee;
            int notBuy = fun(pos + 1, 0, prices, map, fee);
            x = Math.max(buy, notBuy);
        } else {
            int sell = fun(pos + 1, 0, prices, map, fee) + prices[pos];
            int notSell = fun(pos + 1, 1, prices, map, fee);
            x = Math.max(sell, notSell);
        }
        map.put(pos + " " + buyOrSell, x);
        return x;
    }
}
