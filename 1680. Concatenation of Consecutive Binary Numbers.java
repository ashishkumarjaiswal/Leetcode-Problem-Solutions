class Solution {
    public int concatenatedBinary(int n) {
        int count = 0;
        int mod = 1000000007;
        long ans = 0;

        for (int i = 1; i <= n; i++) {
            if (((i - 1) & i) == 0)
                count++;

            ans = ((ans << count) + i) % mod;
        }

        return (int) ans;
    }
}
