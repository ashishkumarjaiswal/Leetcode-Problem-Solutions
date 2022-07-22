class Solution {
    int ans = 0;
    boolean[] visited;

    public int arrayNesting(int[] nums) {
        visited = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i])
                fun(nums, 0, i);
        }

        return ans;
    }

    void fun(int[] nums, int count, int index) {
        ans = Math.max(ans, count);

        if (visited[index]) {
            return;
        }

        visited[index] = true;
        fun(nums, count + 1, nums[index]);
    }
}
