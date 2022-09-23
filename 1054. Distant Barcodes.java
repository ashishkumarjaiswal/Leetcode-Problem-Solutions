class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : barcodes) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i : map.keySet()) {
            q.add(new int[] { i, map.get(i) });
        }

        int[] ans = new int[barcodes.length];
        int index = 0;
        int val = q.peek()[0];
        int count = q.poll()[1];
        int size = barcodes.length;

        while (size >= 0) {
            ans[index] = val;
            count--;
            size--;

            if (count == 0) {
                if (q.isEmpty())
                    return ans;

                val = q.peek()[0];
                count = q.poll()[1];
            }

            index = index + 2;

            if (index >= barcodes.length)
                index = 1;
        }

        return ans;
    }
}
