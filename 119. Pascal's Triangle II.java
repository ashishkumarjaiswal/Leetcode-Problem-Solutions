class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        res.add(1);
        if (rowIndex == 0)
            return res;
        res.add(1);
        if (rowIndex == 1) {
            return res;
        }
        for (int i = 2; i <= rowIndex; i++) {
            ret = new ArrayList<>();
            ret.add(1);
            for (int j = 0; j < i - 1; j++) {
                ret.add(res.get(j) + res.get(j + 1));
            }
            ret.add(1);
            res = new ArrayList<>(ret);
        }
        return res;
    }
}
