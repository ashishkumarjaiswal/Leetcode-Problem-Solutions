class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int ans = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int[] station : stations) {
            int dis = station[0];
            int fuel = station[1];

            while (startFuel < dis) {
                if (q.isEmpty())
                    return -1;

                int x = q.poll();
                startFuel = startFuel + x;
                ans++;
            }

            q.add(fuel);
        }

        while (startFuel < target) {
            if (q.isEmpty())
                return -1;

            int x = q.poll();
            startFuel = startFuel + x;
            ans++;
        }

        return ans;
    }
}
