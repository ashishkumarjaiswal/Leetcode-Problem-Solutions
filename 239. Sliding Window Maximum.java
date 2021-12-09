class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] nextGreaterElement = new int[nums.length];
        int[] ans = new int[nums.length - k + 1];
        Stack<Integer> st = new Stack<>();
        nextGreaterElement[nums.length - 1] = nums.length;
        st.push(nums.length - 1);
        for (int i = nums.length - 2; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] >= nums[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                nextGreaterElement[i] = nums.length;
            else
                nextGreaterElement[i] = st.peek();
            st.push(i);
        }
        int j = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            if (i > j)
                j = i;
            while (nextGreaterElement[j] < i + k)
                j = nextGreaterElement[j];
            ans[i] = nums[j];
        }
        return ans;
    }
}
