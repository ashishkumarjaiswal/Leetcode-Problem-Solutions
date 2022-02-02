class Solution {
    public int minOperations(int n) {
        int mid = 0;

        if ((n & 1) == 1) {
            mid = (2 * (n >> 1)) + 1;
        } else {
            mid = ((n >> 1) * 2) + 1;
            mid--;
        }
        int sum = 0, prev = 1;
        for (int i = 0; i < (n >> 1); i++) {
            sum = sum + prev;
            prev = prev + 2;
        }
        mid = mid * (n >> 1);

        return mid - sum;

    }
}
