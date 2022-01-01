class Solution {
    public String reformat(String s) {
        int num = 0, ch = 0;
        StringBuilder n = new StringBuilder();
        StringBuilder c = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num++;
                n.append(s.charAt(i));
            } else {
                ch++;
                c.append(s.charAt(i));
            }
        }
        if (!(Math.abs(num - ch) <= 1))
            return "";
        if (c.length() > n.length())
            return add(c.toString(), n.toString());
        else
            return add(n.toString(), c.toString());

    }

    String add(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            sb.append(s1.charAt(i));
            if (i < s2.length())
                sb.append(s2.charAt(i));
        }
        return sb.toString();
    }
}
