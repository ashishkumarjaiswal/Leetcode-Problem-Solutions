class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ')') {
                if (!st.isEmpty()) {
                    sb.append(c);
                    st.pop();
                }
            } else if (c == '(') {
                st.push(c);
                sb.append(c);
            } else {
                sb.append(c);
            }
        }

        s = sb.toString();
        sb = new StringBuilder();
        st = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '(') {
                if (!st.isEmpty()) {
                    sb.append(c);
                    st.pop();
                }
            } else if (c == ')') {
                st.push(c);
                sb.append(c);
            } else {
                sb.append(c);
            }
        }

        return sb.reverse().toString();
    }
}
