class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        for (int i = 0; i < manager.length; i++) {
            if (manager[i] != -1) {
                if (!map.containsKey(manager[i]))
                    map.put(manager[i], new ArrayList<>());

                map.get(manager[i]).add(i);
            }
        }

        return dfs(headID, informTime);
    }

    int dfs(int head, int[] informTime) {
        int ans = 0;

        List<Integer> list = map.get(head);

        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                ans = Math.max(ans, dfs(list.get(i), informTime));
            }
        }

        return ans + informTime[head];
    }
}
