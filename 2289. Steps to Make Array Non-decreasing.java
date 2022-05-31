class Solution {
    class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public int totalSteps(int[] nums) {
        Stack<Pair> st = new Stack<>();
        int ans = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            int count = 0;

            while (!st.isEmpty() && nums[i] > st.peek().key) {
                count = Math.max(count + 1, st.peek().value);
                st.pop();
            }

            ans = Math.max(ans, count);

            st.push(new Pair(nums[i], count));

        }

        return ans;
    }
}
