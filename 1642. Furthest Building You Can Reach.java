class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];

            if (diff > 0) {
                q.add(diff);
            }

            if (q.size() > ladders) {
                bricks = bricks - q.poll();
            }

            if (bricks < 0)
                return i;
        }

        return heights.length - 1;
    }
}
