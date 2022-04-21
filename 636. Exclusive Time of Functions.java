class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer[]> st = new Stack<>();
        int[] ans = new int[n];

        for (int i = 0; i < logs.size(); i++) {
            String[] temp = logs.get(i).split(":");

            Integer[] arr = new Integer[3];

            arr[0] = Integer.parseInt(temp[0]);
            arr[1] = Integer.parseInt(temp[2]);
            arr[2] = 0;

            if (temp[1].equals("start")) {
                st.push(arr);
            } else {
                Integer[] a = st.pop();

                int totalTime = arr[1] - a[1] + 1;
                int time = totalTime - a[2];
                ans[arr[0]] = time + ans[arr[0]];

                if (!st.isEmpty()) {
                    st.peek()[2] += totalTime;
                }
            }
        }
        return ans;
    }
}
