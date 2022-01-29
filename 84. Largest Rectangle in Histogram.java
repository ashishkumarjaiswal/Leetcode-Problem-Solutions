//New One

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> inc = new Stack<>();
        int[] left = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (!inc.isEmpty() && heights[inc.peek()] >= heights[i]) {
                inc.pop();
            }
            if (inc.isEmpty())
                left[i] = -1;
            else
                left[i] = inc.peek();
            inc.push(i);
        }
        Stack<Integer> dec = new Stack<>();
        int[] right = new int[heights.length];

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!dec.isEmpty() && heights[i] <= heights[dec.peek()]) {
                dec.pop();
            }
            if (dec.isEmpty())
                right[i] = heights.length;
            else
                right[i] = dec.peek();
            dec.push(i);
        }

        int max = 0;
        for (int i = 0; i < right.length; i++) {
            max = Math.max(max, ((right[i] -left[i]) - 1) * heights[i]);
        }
        return max;

    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        int h = heights.length;
        int[] rb = new int[h];
        int[] lb = new int[h];
        Stack<Integer> st = new Stack<>();
        st.push(h - 1);
        rb[h - 1] = h;
        for (int i = h - 2; i >= 0; i--) {
            while (st.size() > 0 && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0)
                rb[i] = h;
            else
                rb[i] = st.peek();
            st.push(i);
        }
        st = new Stack<>();
        lb[0] = -1;
        st.push(0);
        for (int i = 1; i < h; i++) {
            while (st.size() > 0 && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0)
                lb[i] = -1;
            else
                lb[i] = st.peek();
            st.push(i);
        }
        int area = 0;
        for (int i = 0; i < h; i++) {
            int x = (rb[i] - lb[i] - 1) * heights[i];
            if (x > area)
                area = x;
        }
        return area;
    }
}
