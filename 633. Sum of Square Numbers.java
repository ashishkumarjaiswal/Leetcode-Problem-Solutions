class Solution {
    public boolean judgeSquareSum(int c) {
        int high = (int) Math.sqrt(c);
        int low = 0;

        while (low <= high) {
            long total = low * low + high * high;
            if (total == c)
                return true;

            if (total < 0)
                high--;
            else if (total > c)
                high--;
            else
                low++;
        }
        return false;
    }
}
