class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> list = new ArrayList<>();
        int n = graph.length;
        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            if (dfs(graph, i, visited))
                list.add(i);
        }

        return list;
    }

    boolean dfs(int[][] arr, int index, int[] visited) {
        if (visited[index] > 0)
            return visited[index] == 2;

        visited[index] = 1;

        for (int i : arr[index]) {
            if (visited[i] == 2)
                continue;

            if (visited[i] == 1 || !dfs(arr, i, visited))
                return false;
        }

        visited[index] = 2;
        return true;
    }
}
