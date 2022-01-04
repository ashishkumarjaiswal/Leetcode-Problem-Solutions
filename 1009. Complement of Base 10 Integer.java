//by the use of String
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
//Using Bitwise Operator 
class Solution {
    public int bitwiseComplement(int n) {
        if(n==0)
            return 1;
        int mask = 1, num = n;
        while (num != 0) {
            n = n ^ mask;
            mask = mask << 1;
            num = num >> 1;
        }
        return n;
    }
}
