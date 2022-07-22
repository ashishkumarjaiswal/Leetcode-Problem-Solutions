class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans = new int[k];
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int[] log : logs) {
            int key = log[0];
            int val = log[1];

            if (!map.containsKey(key))
                map.put(key, new HashSet<>());

            map.get(key).add(val);
        }

        for (int i : map.keySet()) {
            int size = map.get(i).size();

            ans[size - 1]++;
        }

        return ans;
    }
}
