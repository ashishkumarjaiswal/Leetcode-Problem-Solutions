class Solution {
    public int findCircleNum(int[][] isConnected) {
        return bfs(0, isConnected);
    }

    void fun(boolean[] visited, int[][] isConnected, int i) {
        Queue<Integer> q = new LinkedList<>();
        visited[i] = true;
        q.add(i);
        while (!q.isEmpty()) {
            int front = q.poll();
            for (int j = 0; j < visited.length; j++) {
                if (isConnected[front][j] == 1 && visited[j] == false) {
                    visited[j] = true;
                    q.add(j);
                }
            }
        }
    }

    int bfs(int ans, int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
                ans++;
                fun(visited, isConnected, i);
            }
        }
        return ans;
    }
}
