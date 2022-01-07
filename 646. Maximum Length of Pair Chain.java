class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        int ans = 1;
        int last = pairs[0][1];
        for (int[] i : pairs) {
            if (last < i[0]) {
                last = i[1];
                ans++;
            }
        }
        return ans;
    }
}
