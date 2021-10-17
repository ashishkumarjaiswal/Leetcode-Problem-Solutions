class Solution {
    public String countAndSay(int n) {
        String s = "1";
        if (n == 1)
            return s;
        s = "11";
        if (n == 2)
            return s;
        for (int i = 3; i <= n; i++) {
            int count = 1;
            String temp = "";
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) != s.charAt(j - 1)) {
                    temp = temp + count + s.charAt(j - 1);
                    count = 1;
                } else {
                    count++;
                }
            }
            temp = temp + count + s.charAt(s.length() - 1);
            s = new String(temp);
        }
        return s;
    }
}
