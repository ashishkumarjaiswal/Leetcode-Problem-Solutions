class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] ans = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            ans[i] = new StringBuilder();
        }
        int size = s.length();
        char[] arr = s.toCharArray();
        int ind = 0;
        while (ind < size) {
            for (int i = 0; i < numRows && ind < size; i++) {
                ans[i].append(arr[ind++]);
            }
            for (int i = numRows - 2; i > 0 && ind < size; i--) {
                ans[i].append(arr[ind++]);
            }
        }
        String ret = "";
        for (int i = 0; i < numRows; i++) {
            ret = ret + ans[i].toString();
        }
        return ret;
    }
}
