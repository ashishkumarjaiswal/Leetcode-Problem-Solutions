class Solution {
    public int maxProfit(int[] prices) {
        int b = 0;
        int s = 0;
        int total = 0;
        boolean ashish = true;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1]) {
                ashish = true;
                continue;
            } else {
                total = total + prices[i - 1] - prices[b];
                b = i;
                ashish = false;
            }
        }
        if (ashish) {
            total = total + prices[prices.length - 1] - prices[b];
        }
        return total;
    }
}
