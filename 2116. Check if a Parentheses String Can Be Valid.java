import java.util.*;

class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0)
            return false;

        int free = 0, open = 0, close = 0;

        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0')
                free++;
            else if (s.charAt(i) == '(')
                open++;
            else
                close++;

            if (free + open < close)
                return false;
        }

        free = open = close = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0')
                free++;
            else if (s.charAt(i) == '(')
                open++;
            else
                close++;

            if (free + close < open)
                return false;
        }

        return true;
    }
}
