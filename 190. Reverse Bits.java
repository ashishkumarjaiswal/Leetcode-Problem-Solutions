public class Solution {
    public int reverseBits(int n) {
        int rev = 0, j = 0;
        boolean ashish = false;
        for (int i = 31; i >= 0; i--) {
            int smask = 1 << i;
            if (ashish) {
                if ((smask & n) != 0) {
                    int x = 1 << j;
                    rev = rev | x;
                }

            } else {
                if ((smask & n) != 0) {
                    ashish = true;
                    int x = 1 << j;
                    rev = rev | x;
                }
            }
            j++;
        }
        return rev;
    }
}
