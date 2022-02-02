class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans = 0;
        int x = piles.length - 2;
        for (int i = 0; i < piles.length / 3; i++) {
            ans = ans + piles[x];
            x = x - 2;
        }
        return ans;
    }
}
