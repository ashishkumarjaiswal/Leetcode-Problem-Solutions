class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        fun(graph, 0, new ArrayList<>());
        return ans;
    }

    void fun(int[][] graph, int i, List<Integer> curr) {
        if (i == graph.length - 1) {
            ans.add(curr);
        }

        curr.add(i);

        for (int j = 0; j < graph[i].length; j++) {
            fun(graph, graph[i][j], new ArrayList<>(curr));
        }
    }
}
