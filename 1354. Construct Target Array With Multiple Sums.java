class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Long> q = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;

        for (int i : target) {
            q.add((long) i);
            sum = sum + i;
        }

        while (q.peek() != 1) {
            long top = q.poll();
            sum = sum - top;

            if (sum <= 0 || sum >= top)
                return false;

            top = top % sum;
            sum = sum + top;

            q.add(top > 0 ? top : sum);

        }

        return true;
    }
}
