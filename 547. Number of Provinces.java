//Using Bfs

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        boolean[] visited = new boolean[v];
        int ans = 0;

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                ans++;
                fun(isConnected, i, visited);
            }
        }

        return ans;
    }

    void fun(int[][] isConnected, int sv, boolean[] visited) {
        visited[sv] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[x][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
