class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] one = fun(n);

        for (int i = 0; i < 32; i++) {
            if (Arrays.equals(one, fun(1 << i)))
                return true;
        }

        return false;
    }

    int[] fun(int n) {
        int[] arr = new int[10];

        while (n > 0) {
            arr[n % 10]++;
            n = n / 10;
        }

        return arr;
    }
}
