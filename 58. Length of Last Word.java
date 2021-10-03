class Solution {
    public int lengthOfLastWord(String s) {
        boolean ashish = true;
        int i = s.length() - 1;
        int count = 0;
        while (i >= 0) {
            if (s.charAt(i) == ' ' && ashish) {
                i--;
                continue;
            } else {
                ashish = false;
            }
            if (s.charAt(i) == ' ') {
                break;
            } else {
                count++;
            }
            i--;
        }
        return count;
    }
}
