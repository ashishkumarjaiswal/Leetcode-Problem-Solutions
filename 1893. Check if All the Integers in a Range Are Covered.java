class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        for (int i = left; i <= right; i++) {
            boolean flag = true;
            for (int[] is : ranges) {
                if ((is[0] <= i && is[1] >= i)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return false;
        }
        return true;
    }
}
