class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] arr = new int[numCourses];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (fun(arr, adj, i))
                    return false;
            }
        }
        return true;
    }

    boolean fun(int[] arr, List<List<Integer>> adj, int i) {

        if (arr[i] == 2)
            return true;

        arr[i] = 2;
        
        for (int j = 0; j < adj.get(i).size(); j++) {
            if (arr[adj.get(i).get(j)] != 1) {
                if (fun(arr, adj, adj.get(i).get(j)))
                    return true;
            }
        }
        arr[i] = 1;
        return false;
    }
}
