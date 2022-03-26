class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(c);
            } else {
                st.pop();
            }
            sb.append(c);
            if (st.isEmpty()) {
                ans.append(sb.substring(1, sb.length()-1));
                sb = new StringBuilder();
            }
        }
        return ans.toString();
    }
}
