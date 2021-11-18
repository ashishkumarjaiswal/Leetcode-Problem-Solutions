class Solution {
    public int maxProfit(int[] prices) {
        HashMap<String, Integer> map = new HashMap<>();
        return fun(0, 0, prices, map);
    }

    int fun(int pos, int buyOrSell, int[] prices, HashMap<String, Integer> map) {
        if (pos >= prices.length)
            return 0;
        if (map.containsKey(pos + " " + buyOrSell)) {
            return map.get(pos + " " + buyOrSell);
        }
        int x=0;
        if (buyOrSell == 0) {
            int buy = fun(pos + 1, 1, prices, map) - prices[pos];
            int notBuy = fun(pos + 1, 0, prices, map);
             x = Math.max(buy, notBuy);
        } else {
            int sell = fun(pos + 2, 0, prices, map)+prices[pos];
            int notSell = fun(pos + 1, 1, prices, map);
             x = Math.max(sell, notSell);
        }
        map.put(pos + " " + buyOrSell, x);
        return x;
    }
}

//Another one
class Solution {
    public int maxProfit(int[] prices) {
        int obsp = -prices[0];
        int ossp = 0;
        int ocsp = 0;
        for (int i = 1; i < prices.length; i++) {
            int nbsp = 0;
            int nssp = 0;
            int ncsp = 0;
            if (ocsp - prices[i] > obsp) {
                nbsp = ocsp - prices[i];
            } else {
                nbsp = obsp;
            }
            if (obsp + prices[i] > ossp) {
                nssp = obsp + prices[i];
            } else {
                nssp = ossp;
            }
            if (ossp > ocsp) {
                ncsp = ossp;
            } else {
                ncsp = ocsp;
            }
            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;
        }
        return ossp;
    }
}
