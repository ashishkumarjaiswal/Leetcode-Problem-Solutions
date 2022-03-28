class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : map.keySet()) {
            if (map.get(i) == 0)
                continue;

            int x;
            if (i < 0) {
                if (i % 2 != 0)
                    return false;
                x = i / 2;
            } else
                x = i * 2;

            if (!map.containsKey(x) || map.get(x) == 0)
                return false;
            else {
                if (map.get(i) > map.get(x))
                    return false;
                map.put(x, map.get(x) - map.get(i));
                map.put(i, 0);
            }
        }
        return true;
    }
}
