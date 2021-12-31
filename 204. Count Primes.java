class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        int count = 0;

        for (int i = 2; i * i <= n; i++) {
            if (!isPrime[i]) {
                for (int j = i * 2; j < n; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        for (int i = 2; i < isPrime.length; i++) {
            if (!isPrime[i])
                count++;
        }
        return count;
    }
}
