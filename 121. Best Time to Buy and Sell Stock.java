class Solution {
    public int maxProfit(int[] prices) {
        int maxp = 0;
        int least = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int x = prices[i] - least;
            if (x > maxp)
                maxp = x;
            if (prices[i] < least)
                least = prices[i];
        }
        return maxp;
    }
}
