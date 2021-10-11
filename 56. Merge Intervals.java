class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();
        for (int[] i : intervals) {
            if (ans.size() == 0) {
                ans.add(i);
            } else {
                int[] pre = ans.get(ans.size() - 1);
                if (pre[1] < i[0]) {
                    ans.add(i);
                } else {
                    pre[1] = Math.max(pre[1], i[1]);
                }
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
