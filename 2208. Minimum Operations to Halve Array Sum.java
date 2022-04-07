class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> q = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;

        for (int i : nums) {
            q.add((double) i);
            sum += i;
        }

        double csum = sum / 2.0;
        int count = 0;

        while (!q.isEmpty()) {
            double x = q.poll();
            x = x / 2;
            csum = csum - x;
            q.add(x);
            count++;
            if (csum <= 0)
                break;
        }
        return count;
    }
}
