class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int currSum = 0;

        for (int i : rolls) {
            currSum += i;
        }

        int remaining = ((rolls.length + n) * mean) - currSum;

        int[] arr = new int[n];

        if (n > remaining || n * 6 < remaining) {
            return new int[] {};
        }

        int mod = remaining % n;
        int one = remaining / n;

        for (int i = 0; i < n; i++) {
            arr[i] = one;

            if (mod != 0) {
                arr[i]++;
                mod--;
            }
        }

        return arr;
    }
}
