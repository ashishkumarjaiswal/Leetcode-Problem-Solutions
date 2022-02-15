import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        for (; i < num.length() && k > 0; i++) {
            char c = num.charAt(i);
            while (!st.isEmpty() && st.peek() > c && k > 0) {
                st.pop();
                k--;
            }
            st.push(c);
        }

        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        sb = sb.reverse();

        if (i != num.length()) {
            sb.append(num.substring(i, num.length()));
        }

        if (k != 0) {
            while (k != 0) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
        }

        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        if (sb.length() == 0)
            return "0";

        return sb.toString();
    }
}
