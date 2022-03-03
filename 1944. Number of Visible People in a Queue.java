class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<int[]> st = new Stack<>();
        int ans[] = new int[heights.length];

        for (int i = 0; i < ans.length; i++) {
            while (!st.isEmpty() && st.peek()[1] < heights[i]) {
                int prev = st.pop()[0];
                ans[prev]++;
            }

            if (!st.isEmpty()) {
                int x = st.peek()[0];
                ans[x]++;
            }
            st.push(new int[] { i, heights[i] });
        }
        return ans;
    }
}
