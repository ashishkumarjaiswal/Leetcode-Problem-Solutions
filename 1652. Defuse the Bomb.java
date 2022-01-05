class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        if (k == 0) {
            return ans;
        } else if (k > 0) {
            for (int i = 0; i < ans.length; i++) {
                int x = 0, j = i + 1;
                int total = 0;
                while (x++ < k) {
                    total = total + code[j % ans.length];
                    j++;
                }
                ans[i] = total;
            }
        } else {
            for (int i = 0; i < ans.length; i++) {
                int x = k, j = i + ans.length - Math.abs(k);
                int total = 0;
                while (x++ < 0) {
                    total = total + code[j % ans.length];
                    j++;
                }
                ans[i] = total;
            }
        }
        return ans;
    }
}
