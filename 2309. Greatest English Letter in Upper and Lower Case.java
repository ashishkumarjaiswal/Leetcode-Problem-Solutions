class Solution {
    public String greatestLetter(String s) {
        char[] upper = new char[26];
        char[] lower = new char[26];

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z')
                lower[c - 'a']++;
            else
                upper[c - 'A']++;
        }

        for (int i = 25; i >= 0; i--) {
            if (upper[i] > 0 && lower[i] > 0)
                return (char) ('A' + i) + "";
        }

        return "";
    }
}
