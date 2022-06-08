class Solution {
    public int removePalindromeSub(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        String one = sb.reverse().toString();
        if (one.equals(s))
            return 1;

        return 2;
    }
}
