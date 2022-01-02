class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (s.equals("+")) {
                int one = st.pop();
                int two = st.pop();
                st.push(one + two);
            } else if (s.equals("-")) {
                int one = st.pop();
                int two = st.pop();
                st.push(two - one);
            } else if (s.equals("*")) {
                int one = st.pop();
                int two = st.pop();
                st.push(one * two);
            } else if (s.equals("/")) {
                int one = st.pop();
                int two = st.pop();
                st.push(two / one);
            } else {
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}
