class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Stack<int[]> st = new Stack<>();
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1])
                return b[0] - a[0];
            return a[1] - b[1];
        });
        st.push(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (!st.isEmpty() && st.peek()[1] <= intervals[i][0]) {
                st.push(intervals[i]);
            }
        }
        return intervals.length - st.size();
    }
}
