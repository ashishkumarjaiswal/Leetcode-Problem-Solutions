class Solution {
    public int minCostToMoveChips(int[] position) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < position.length; i++) {
            map.put(position[i], map.getOrDefault(position[i], 0) + 1);
        }
        int even = 0, odd = 0;
        for (int i : map.keySet()) {
            if (i % 2 == 0)
                even = even + map.get(i);
            else
                odd = odd + map.get(i);
        }
        return Math.min(even, odd);
    }
}
