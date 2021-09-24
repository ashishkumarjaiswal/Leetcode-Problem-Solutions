class Solution {
    public String intToRoman(int num) {
        String[] c = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] n = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String ret = "";
        for (int i = 0; i < n.length; i++) {
            while (num >= n[i]) {
                ret = ret + c[i];
                num = num - n[i];
            }
        }
        return ret;
    }
}
