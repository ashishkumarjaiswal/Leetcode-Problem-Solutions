class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        String res = "";
        while (i >= 0 && j >= 0) {
            int x = num1.charAt(i);
            int y = num2.charAt(j);
            int z = x + y + carry - 96;
            carry = z / 10;
            res = Integer.toString(z % 10) + res;
            i--;
            j--;
        }
        if (i == -1 && j == -1 && carry>0) {
            res = Integer.toString(carry) + res;
            return res;
        }
        if (i == -1) {
            while (carry > 0) {
                int x = num2.charAt(j) - 48 + carry;
                if (j == 0) {
                    res = Integer.toString(x) + res;
                    return res;
                }
                int y = x % 10;
                carry = x / 10;
                res = Integer.toString(y) + res;
                j--;
            }
            res = num2.substring(0, j + 1) + res;
        }
        if (j == -1) {
            while (carry > 0) {
                int x = num1.charAt(i) - 48 + carry;
                if (i == 0) {
                    res = Integer.toString(x) + res;
                    return res;
                }
                int y = x % 10;
                carry = x / 10;
                res = Integer.toString(y) + res;
                i--;
            }
            res = num1.substring(0, i + 1) + res;
        }
        return res;
    }
}
