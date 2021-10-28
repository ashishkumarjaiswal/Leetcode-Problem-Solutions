class Solution {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        int x = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int num = columnTitle.charAt(i) - 'A' + 1;
            ans = ans + (int) Math.pow(26, x) * num;
            x++;
        }
        return ans;
    }
}
