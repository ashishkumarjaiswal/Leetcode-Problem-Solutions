class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z)
            return false;

        int[] dir = { x, -x, y, -y };
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        visited.add(0);
        q.add(0);

        while (!q.isEmpty()) {
            int a = q.poll();
            if (a == z)
                return true;

            for (int d : dir) {
                int p = d + a;
                if (p == z)
                    return true;
                if (x + y < p || p < 0)
                    continue;
                if (!visited.contains(p)) {
                    q.add(p);
                    visited.add(p);
                }
            }

        }
        return false;
    }
}
