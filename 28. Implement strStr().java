class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        if (needle.length() > haystack.length())
            return -1;
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                int x = i;
                while (x < haystack.length()) {
                    if (haystack.charAt(x) == needle.charAt(j)) {
                        j++;
                        x++;
                        if (j == needle.length())
                            return i;
                    } else {
                        j = 0;
                        break;
                    }
                }
            }
        }
        return -1;
    }
}
