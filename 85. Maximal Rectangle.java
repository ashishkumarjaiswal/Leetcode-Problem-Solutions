class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0)
        return 0;
        int[] arr = new int[matrix[0].length];
        int total = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0')
                    arr[j] = 0;
                else
                    arr[j] = arr[j] + 1;
            }
            int max = fun(arr);
            if (max > total)
                total = max;
        }
        return total;
    }

    public int fun(int[] heights) {
        // for (int i = 0; i < heights.length; i++) {
        //     System.out.print(heights[i]);
        // }
        // System.out.println();
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
