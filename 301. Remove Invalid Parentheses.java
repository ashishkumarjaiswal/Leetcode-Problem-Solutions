import java.util.*;

class Solution {
    HashSet<String> set = new HashSet<>();
    List<String> ans = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        int count = length(s);
        fun(s, count);

        return ans;
    }

    void fun(String s, int count) {
        if (set.contains(s))
            return;

        set.add(s);
        if (count == 0) {
            if (length(s) == 0) {
                ans.add(s);
            }
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                String left = s.substring(0, i);
                String right = s.substring(i + 1);
                fun(left + right, count - 1);
            }
        }
    }

    int length(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(')
                st.push(c);
            else if (c == ')') {
                if (st.isEmpty() || st.peek() == ')') {
                    st.push(c);
                } else {
                    st.pop();
                }
            }
        }
        return st.size();
    }
}
