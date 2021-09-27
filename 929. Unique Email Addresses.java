class Solution {
    public int numUniqueEmails(String[] emails) {
        HashMap<String, Integer> ashish = new HashMap<>();
        for (int i = 0; i < emails.length; i++) {
            String a = fun(emails[i]);
            ashish.put(a, ashish.getOrDefault(a, 0) + 1);
        }
        List<String> r = new ArrayList<>(ashish.keySet());
        return r.size();
    }

    public String fun(String s) {
        String a = "";
        boolean ashish = true;
        boolean aman = false;
        for (int i = 0; i < s.length(); i++) {
            if (aman) {
                if (s.charAt(i) == '@') {
                    aman = false;
                    ashish = false;
                    a = a + s.substring(i, i + 1);
                    continue;
                } else
                    continue;
            }
            if (s.charAt(i) == '.') {
                if (ashish)
                    continue;
                else
                    a = a + s.substring(i, i + 1);
            } else if (s.charAt(i) == '@') {
                ashish = false;
                a = a + s.substring(i, i + 1);
            } else if (s.charAt(i) == '+') {
                aman = true;
                continue;
            } else
                a = a + s.substring(i, i + 1);
        }
        return a;
    }
}
