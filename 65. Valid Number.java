import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isNumber(String s) {
        boolean dot, eseen, digit;
        dot = eseen = digit = false;
        int plusMinus = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                digit = true;
            } else if (c == '.') {

                if (dot || eseen) {
                    return false;
                }

                if (i == s.length() - 1 && !digit)
                    return false;

                dot = true;
            } else if (c == '+' || c == '-') {
                if (plusMinus == 2)
                    return false;
                if (i > 0 && (s.charAt(i - 1) != 'E' && s.charAt(i - 1) != 'e'))
                    return false;
                if (s.length() - 1 == i)
                    return false;
                plusMinus++;
            } else if (c == 'e' || c == 'E') {

                if (!digit || i == s.length() - 1 || eseen)
                    return false;

                eseen = true;
            } else {
                return false;
            }

        }

        return true;
    }
}
