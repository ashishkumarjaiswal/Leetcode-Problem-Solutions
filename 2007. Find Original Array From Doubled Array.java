class Solution {
    public int[] findOriginalArray(int[] changed) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = changed.length;

        for (int i : changed) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int[] ans = new int[n / 2];
        int x = 0;

        for (int i : map.keySet()) {
            if (i == 0) {
                int count = map.get(0);
                if (count % 2 != 0) {
                    return new int[] {};
                }

                for (int j = 0; j < count / 2; j++) {
                    ans[x++] = 0;
                }

                continue;
            }

            int size = map.get(i);
            for (int j = 0; j < size; j++) {
                int d = i * 2;

                if (map.containsKey(d) && map.get(d) > 0) {
                    ans[x++] = i;
                    map.put(i, map.get(i) - 1);
                    map.put(d, map.get(d) - 1);
                } else if (i % 2 == 0 && map.containsKey(i / 2) && map.get(i / 2) > 0) {
                    ans[x++] = i / 2;

                    map.put(i, map.get(i) - 1);
                    map.put(i / 2, map.get(i / 2) - 1);
                } else {
                    return new int[] {};
                }
            }
        }

        return ans;
    }
}
