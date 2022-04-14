class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        HashSet<Long> set = new HashSet<>();
        Queue<Long> q = new LinkedList<>();
        q.add((long) start);
        int count = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                long a = q.poll();

                if (a == goal)
                    return count;

                if (set.contains(a) || a < 0 || a > 1000)
                    continue;

                for (int j = 0; j < nums.length; j++) {
                    q.add(a + nums[j]);
                    q.add(a - nums[j]);
                    q.add(a ^ nums[j]);
                }
                set.add(a);
            }
            count++;
        }

        return -1;
    }
}
