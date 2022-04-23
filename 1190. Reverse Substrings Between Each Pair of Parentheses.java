class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ')') {
                StringBuilder sb = new StringBuilder();

                while (true) {
                    if (st.peek() == '(') {
                        st.pop();
                        break;
                    }

                    sb.append(st.pop());
                }

                for (int j = 0; j < sb.length(); j++) {
                    st.push(sb.charAt(j));
                }
            } else {
                st.push(c);
            }
        }
        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }
}
