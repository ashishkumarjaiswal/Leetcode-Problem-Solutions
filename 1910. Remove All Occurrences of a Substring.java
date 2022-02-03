import java.util.*;

class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        int i = 0;

        i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == part.charAt(0)) {
                if ((i + part.length()) <= s.length() && s.substring(i, i + part.length()).equals(part)) {
                    s = s.substring(0, i) + s.substring(i + part.length());
                    i = 0;
                    continue;
                }
            }
            i++;
            // sb.append(s.charAt(i));

        }
        return s;
    }
}
