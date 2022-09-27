class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : piles) {
            q.add(i);
        }

        while (k-- > 0) {
            if (q.peek() == 1)
                break;
            int a = q.poll();
            int x = (a + 1) / 2;

            q.add(x);
        }

        int ans = 0;

        while (!q.isEmpty()) {
            ans = ans + q.poll();
        }

        return ans;
    }
}
