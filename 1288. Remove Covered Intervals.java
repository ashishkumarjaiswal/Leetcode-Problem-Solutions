class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });
        int count = 0;
        Stack<int[]> st = new Stack<>();

        for (int i = 0; i < intervals.length; i++) {
            while (!st.isEmpty() && st.peek()[0] >= intervals[i][0]) {
                if (st.peek()[1] <= intervals[i][1]) {
                    System.out.println(i);
                    st.pop();
                    count++;
                }
            }
            st.push(intervals[i]);
        }
        return intervals.length - count;
    }
}
