
class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        StringBuilder ans = new StringBuilder();
        boolean carry = false;
        while (i >= 0 && j >= 0) {
            int temp = Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(b.charAt(j));
            System.out.println(temp);
            if (temp == 2) {
                if (!carry) {
                    carry = true;
                    ans.append("0");
                } else
                    ans.append("1");
            } else if (temp == 1) {
                if (!carry) {
                    ans.append("1");
                } else
                    ans.append("0");
            } else {
                if (carry) {
                    ans.append("1");
                    carry = false;
                } else
                    ans.append("0");
            }
            i--;
            j--;
        }
        while (i >= 0) {
            if (!carry) {
                ans.append(a.charAt(i));
            } else {
                if (a.charAt(i) == '0') {
                    ans.append(1);
                    carry = false;
                } else {
                    ans.append("0");
                }
            }
            i--;
        }
        while (j >= 0) {
            if (!carry) {
                ans.append(b.charAt(j));
            } else {
                if (b.charAt(j) == '0') {
                    carry = false;
                    ans.append("1");
                } else {
                    ans.append("0");
                }
            }
            j--;
        }
        if (carry)
            ans.append("1");
        return ans.reverse().toString();
    }
}
