class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int ans = 0;
        for (int i = 0; i < g.length; i++) {
            while (count < s.length) {
                if (g[i] <= s[count]) {
                    ans++;
                    break;
                }
                count++;
            }
            count++;
        }
        return ans;
    }
}
