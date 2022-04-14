class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int ans = 0;
        int mod = 1000000007;

        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
        }

        for (int i = 0; i < k; i++) {
            int x = q.poll();
            x++;
            q.add(x);
        }

        long multi = 1;

        while (!q.isEmpty()) {
            multi = multi * q.poll();
            multi = multi % mod;
        }

        return (int) multi;
    }
}
