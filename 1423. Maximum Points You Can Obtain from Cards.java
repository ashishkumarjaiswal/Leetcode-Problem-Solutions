class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int ans = 0;
        int i = 0;

        for (; i < k; i++) {
            sum += cardPoints[i];
        }

        ans = sum;
        int j = cardPoints.length - 1;

        while (--i >= 0) {
            sum = sum - cardPoints[i] + cardPoints[j];
            ans = Math.max(ans, sum);
            j--;
        }

        return ans;
    }
}
