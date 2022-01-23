class Solution {
    public String firstPalindrome(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            int start = 0, end = s.length() - 1;
            boolean flag = true;
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) {
                    flag = false;
                    break;
                }
                start++;
                end--;
            }
            if (flag)
                return s;
        }
        return "";
    }
}
