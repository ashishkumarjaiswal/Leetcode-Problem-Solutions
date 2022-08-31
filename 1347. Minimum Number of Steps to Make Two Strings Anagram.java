class Solution {
    public int minSteps(String s, String t) {
        int n = s.length();
        int[] one = new int[26];
        int count = 0;

        for (char c : s.toCharArray()) {
            int x = c - 'a';
            one[x]++;
        }

        for (char c : t.toCharArray()) {
            int x = c - 'a';
            one[x]--;
        }

        for (int i : one) {
            count = count + Math.abs(i);
        }

        return count/2;
    }
}
