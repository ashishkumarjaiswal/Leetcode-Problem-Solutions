class FindSumPairs {
    int[] one;
    int[] two;
    HashMap<Integer, Integer> mapone;
    HashMap<Integer, Integer> maptwo;

    public FindSumPairs(int[] nums1, int[] nums2) {
        one = nums1;
        two = nums2;
        mapone = new HashMap<>();
        maptwo = new HashMap<>();

        for (int i : nums1) {
            mapone.put(i, mapone.getOrDefault(i, 0) + 1);
        }
        for (int i : nums2) {
            maptwo.put(i, maptwo.getOrDefault(i, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int x = two[index];
        maptwo.put(x, maptwo.get(x) - 1);

        if (maptwo.get(x) == 0)
            maptwo.remove(x);

        two[index] += val;
        int y = two[index];
        maptwo.put(y, maptwo.getOrDefault(y, 0) + 1);
    }

    public int count(int tot) {
        int count = 0;

        // for (int i : mapone.keySet()) {
        // int x = tot - i;

        // if (maptwo.containsKey(x)) {
        // count = count + (i * maptwo.get(x));
        // }
        // }
        for (int i : one) {
            int x = tot - i;
            count = count + maptwo.getOrDefault(x, 0);
        }
        return count;
    }
}
