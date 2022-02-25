class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (st.isEmpty()) {
                st.push(c);
                continue;
            }
            if (Math.abs(st.peek() - c) == 32) {
                st.pop();
            } else {
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
