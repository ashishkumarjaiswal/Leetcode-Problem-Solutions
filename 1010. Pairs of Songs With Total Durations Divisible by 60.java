class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            int x = time[i] % 60;
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int count = 0;
        List<Integer> list = new ArrayList<>(map.keySet());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0 || list.get(i) == 30) {
                int x = ((map.get(list.get(i))) * (map.get(list.get(i)) - 1)) / 2;
                count = count + x;
                continue;
            }
            if (list.get(i) < 30) {
                count = count + map.getOrDefault((60 - list.get(i)), 0) * map.get(list.get(i));
            }
        }
        return count;
    }
}
