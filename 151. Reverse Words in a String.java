class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            StringBuilder temp = new StringBuilder();
            while (i >= 0 && s.charAt(i) != ' ') {
                temp.append(s.charAt(i));
                i--;
            }
            if (temp.length() > 0) {
                ans.append(ans.length() == 0 ? "" : " ");
                ans.append(temp.reverse().toString());
            }
        }
        return ans.toString();
    }
}
