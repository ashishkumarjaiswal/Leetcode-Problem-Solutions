class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int v = rooms.size();
        boolean[] visited = new boolean[v];
        int ans = 0;

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                ans++;
                fun(rooms, visited, i);
            }
        }

        return ans == 1;
    }

    void fun(List<List<Integer>> rooms, boolean[] visited, int sv) {
        visited[sv] = true;

        for (int i : rooms.get(sv)) {
            if (!visited[i]) {
                fun(rooms, visited, i);
            }
        }
    }
}
