class Solution {
    public String breakPalindrome(String palindrome) {
        char[] ashish = palindrome.toCharArray();
        if (ashish.length < 2)
            return "";
        for (int i = 0; i < ashish.length / 2; i++) {
            if (ashish[i] != 'a') {
                ashish[i] = 'a';
                return String.valueOf(ashish);
            }
        }
        ashish[ashish.length - 1] = 'b';
        return String.valueOf(ashish);
    }
}
