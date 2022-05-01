class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i] = 1;

                while (!q.isEmpty()) {
                    int curr = q.poll();

                    for (int x : graph[curr]) {
                        if (color[x] == 0) {
                            color[x] = -color[curr];
                            q.add(x);
                        }

                        if (color[curr] == color[x])
                            return false;
                    }
                }
            }
        }
        return true;
    }
}
