class Solution {
    public String maxValue(String n, int x) {
        int size = n.length();

        if (n.charAt(0) == '-') {
            for (int i = 1; i < n.length(); i++) {
                char c = n.charAt(i);

                if (Character.getNumericValue(c) > x) {
                    n = n.substring(0, i) + x + n.substring(i);
                    return n;
                }
            }
        } else {
            for (int i = 0; i < n.length(); i++) {
                char c = n.charAt(i);

                if (Character.getNumericValue(c) < x) {
                    n = n.substring(0, i) + x + n.substring(i);
                    return n;
                }
            }
        }
        if (n.length() == size) {
            n = n + x;
        }
        return n;
    }
}
