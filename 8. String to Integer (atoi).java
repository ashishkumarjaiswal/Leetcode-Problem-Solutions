class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0)
            return 0;
        boolean isNeagtive = false;
        int i = 0;
        if (s.charAt(0) == '-' || s.charAt(0) == '+')
            i = 1;
        if (s.charAt(0) == '-')
            isNeagtive = true;
        long ans = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ' || !Character.isDigit(s.charAt(i)))
                break;
            ans = ans * 10 + Integer.parseInt(s.substring(i, i + 1));
            if (!isNeagtive && ans > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (isNeagtive && -(ans) < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            i++;
        }
        return (int) (isNeagtive ? -ans : ans);
    }
}
