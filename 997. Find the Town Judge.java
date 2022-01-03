class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n == 1)
            return 1;
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < trust.length; i++) {
            map.put(trust[i][1], map.getOrDefault(trust[i][1], 0) + 1);
            set.add(trust[i][0]);
        }
        for (int i : map.keySet()) {
            if (!set.contains(i)) {
                if (map.get(i) == n - 1)
                    return i;
            }
        }
        return -1;
    }
}
