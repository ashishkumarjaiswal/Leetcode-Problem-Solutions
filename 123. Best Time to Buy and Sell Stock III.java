class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] ltr = new int[len];
        int[] rtl = new int[len];
        int min = prices[0];
        ltr[0] = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] - min > ltr[i - 1]) {
                ltr[i] = prices[i] - min;
            } else {
                ltr[i] = ltr[i - 1];
            }
            if (min > prices[i]) {
                min = prices[i];
            }
        }
        int max = prices[len - 1];
        rtl[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            if (max - prices[i] > rtl[i + 1]) {
                rtl[i] = max - prices[i];
            } else {
                rtl[i] = rtl[i + 1];
            }
            if (max < prices[i])
                max = prices[i];
        }
        int total = ltr[len - 1];
        for (int i = 0; i < rtl.length; i++) {
            int x = rtl[i] + ltr[i];
            if (x > total)
                total = x;
        }
        return total;
    }
}
