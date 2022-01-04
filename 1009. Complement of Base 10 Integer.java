class Solution {
    public int bitwiseComplement(int n) {
        String str = Integer.toBinaryString(n);
        String s = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0')
                s = s + '1';
            else
                s = s + '0';
        }
        return Integer.parseInt(s, 2);
    }
}
