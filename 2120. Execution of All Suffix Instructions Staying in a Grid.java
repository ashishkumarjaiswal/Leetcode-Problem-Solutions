import java.util.ArrayList;
import java.util.*;

class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] ans = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {

            int xi = startPos[0], xj = startPos[1];
            int count = 0;

            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == 'R') {
                    xj++;
                } else if (s.charAt(j) == 'L') {
                    xj--;
                } else if (s.charAt(j) == 'U') {
                    xi--;
                } else if (s.charAt(j) == 'D') {
                    xi++;
                }
                if (!isValid(xi, xj, n))
                    break;
                count++;
            }
            ans[i] = count;
        }
        return ans;
    }

    boolean isValid(int i, int j, int n) {
        if (i < 0 || j < 0 || i >= n || j >= n)
            return false;
        return true;
    }
}
