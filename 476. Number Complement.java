class Solution {
    public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        String comp = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                comp = comp + '1';
            else
                comp = comp + '0';
        }
        return Integer.parseInt(comp, 2);
    }
}
