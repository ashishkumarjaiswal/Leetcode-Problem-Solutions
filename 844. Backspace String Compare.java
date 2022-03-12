class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if (!st.isEmpty())
                    st.pop();
            } else {
                st.push(c);
            }
        }

        // "y#fo##f"
        // "y#f#o##f"
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c == '#') {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.equals(st);
    }
}
