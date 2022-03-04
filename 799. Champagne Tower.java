class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if (poured == 0)
            return 0;

        List<Double> l = new ArrayList<>();
        l.add((double) poured);

        while (query_row-- > 0) {
            List<Double> temp = new ArrayList<>();
            temp.add(Math.max((l.get(0) - 1) / 2, 0));
            for (int i = 1; i < l.size(); i++) {
                temp.add(Math.max((l.get(i - 1) - 1) / 2, 0) +
                        Math.max((l.get(i) - 1) / 2, 0));
            }
            temp.add(temp.get(0));
            l = new ArrayList<>(temp);
        }
        return Math.min(l.get(query_glass), 1);

    }
}
