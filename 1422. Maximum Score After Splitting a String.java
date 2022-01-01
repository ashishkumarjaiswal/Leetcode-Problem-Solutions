class Solution {
    public int maxScore(String s) {
        int[] zero = new int[s.length()];
        int[] one = new int[s.length()];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count++;
            }
            zero[i] = count;
        }
        count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                count++;
            }
            one[i] = count;
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < one.length - 1; i++) {
            int x = zero[i] + one[i+1];
            if (x > max)
                max = x;
        }
       
        return max;
    }
}
