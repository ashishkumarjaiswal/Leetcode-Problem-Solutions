class Solution {
    public int triangularSum(int[] nums) {
        Queue<Integer> q = new LinkedList<>();

        for (int i : nums) {
            q.add(i);
        }

        while (q.size() > 1) {
            int size = q.size();

            for (int i = 0; i < size - 1; i++) {
                int x = q.poll() + q.peek();
                q.add(x%10);
            }

            if (q.size() > 1)
                q.poll();
        }

        return q.peek();
    }
}
