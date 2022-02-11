class Solution {
    public int minOperations(String[] logs) {
        Stack<String> st = new Stack<>();

        for (int i = 0; i < logs.length; i++) {
            String s = logs[i];

            if (s.equals("../")) {
                if (!st.isEmpty())
                    st.pop();
            } else if (!s.equals("./")) {
                st.push(s);
            }
        }

        return st.size();
    }
}
