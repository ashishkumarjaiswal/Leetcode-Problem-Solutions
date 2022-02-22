class Solution {
    public int minimumSum(int num) {
        char[] s = Integer.toString(num).toCharArray();
        Arrays.sort(s);
        String n = s[0] + "" + s[3];
        String m = s[1] + "" + s[2];
        return Integer.parseInt(n) + Integer.parseInt(m);
    }
}
