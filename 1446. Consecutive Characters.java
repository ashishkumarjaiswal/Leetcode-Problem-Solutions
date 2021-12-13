class Solution {
    public int maxPower(String s) {
        int count = 1, max = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                count++;
            } else {
                count = 1;
            }
            if (count > max)
                max = count;
        }
        return max;
    }
}
