
class Solution {
    public int minimumLines(int[][] stockPrices) {
        if (stockPrices.length <= 1)
            return 0;

        int count = 1;
        Arrays.sort(stockPrices, (a, b) -> a[0] - b[0]);

        for (int i = 2; i < stockPrices.length; i++) {
            int x1 = stockPrices[i - 2][0];
            int y1 = stockPrices[i - 2][1];
            int x2 = stockPrices[i - 1][0];
            int y2 = stockPrices[i - 1][1];
            int x3 = stockPrices[i][0];
            int y3 = stockPrices[i][1];

            if ((y2 - y1) * (x3 - x2) != (y3 - y2) * (x2 - x1))
                count++;
        }

        return count;
    }
}
