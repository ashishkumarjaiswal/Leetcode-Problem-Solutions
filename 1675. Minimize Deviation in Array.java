class Solution {
    public int minimumDeviation(int[] nums) {
        int min = Integer.MAX_VALUE, diff = Integer.MAX_VALUE;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : nums) {
            if (i % 2 == 1) {
                i = i * 2;
            }
            min = Math.min(i, min);
            q.add(i);
        }

        while (q.peek() % 2 == 0) {
            int max = q.poll();
            diff = Math.min(diff, max - min);
            min = Math.min(min, max / 2);
            q.add(max / 2);
        }
        return Math.min(q.peek() - min, diff);
    }
}
