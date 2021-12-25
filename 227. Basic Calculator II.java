class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        char sign = ' ';
        String val = "";
        s = s.replaceAll("\\s", "");
        System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)))
                continue;
            if (i != 0)
                sign = s.charAt(i - 1);
            val = "";
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                val = val + s.charAt(i);
                i++;
            }
            i--;
            if (sign == '+' || sign == '-') {
                val = sign + val;
            }
            if (sign == '*') {
                int a = st.pop();
                a = a * Integer.parseInt(val);
                st.push(a);
                continue;
            }
            if (sign == '/') {
                int a = st.pop();
                a = a / Integer.parseInt(val);
                st.push(a);
                continue;
            }
            st.push(Integer.parseInt(val));
        }
        int sum = 0;
        while (!st.isEmpty()) {
            sum = sum + st.pop();
        }
        return sum;
    }
}
