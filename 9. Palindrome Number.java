class Solution {
    public boolean isPalindrome(int x) {
        long a = 0;
        long b = x;
        if (x < 0)
            return false;
        while (x != 0) {
            a = a * 10 + x % 10;
            x = x / 10;
        }
        if (a == b)
            return true;
        return false;
    }
}
