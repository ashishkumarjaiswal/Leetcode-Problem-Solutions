class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();

    public int[] findOrder(int n, int[][] prerequisites) {
        boolean[] visited = new boolean[n];
        boolean[] curr = new boolean[n];

        createGraph(prerequisites);

        for (int i = 0; i < n; i++) {
            if (!visited[i] && isCyclic(visited, curr, i))
                return new int[0];
        }

        int ans[] = topoSort(n);

        return ans;
    }

    int[] topoSort(int n) {
        boolean[] visited = new boolean[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, st);
                st.push(i);
            }
        }

        int[] arr = new int[n];
        int i = 0;

        while (!st.isEmpty()) {
            arr[i++] = st.pop();
        }

        return arr;
    }

    void dfs(int index, boolean[] visited, Stack<Integer> st) {
        visited[index] = true;

        List<Integer> list = map.getOrDefault(index, new ArrayList<>());

        for (Integer i : list) {
            if (!visited[i]) {
                dfs(i, visited, st);
                st.push(i);
            }
        }
    }

    void createGraph(int[][] arrs) {
        for (int[] arr : arrs) {
            int x = arr[0];
            int y = arr[1];

            if (!map.containsKey(y))
                map.put(y, new ArrayList<>());

            map.get(y).add(x);
        }
    }

    boolean isCyclic(boolean[] visited, boolean[] curr, int index) {
        visited[index] = true;
        curr[index] = true;

        List<Integer> list = map.getOrDefault(index, new ArrayList<>());

        for (int i : list) {
            if (curr[i])
                return true;

            if (!visited[i] && isCyclic(visited, curr, i)) {
                return true;
            }
        }

        curr[index] = false;
        return false;
    }
}
