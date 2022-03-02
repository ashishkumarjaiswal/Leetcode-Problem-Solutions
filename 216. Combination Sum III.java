class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        fun(1, new ArrayList<>(), n, k);
        return ans;
    }

    void fun(int start, List<Integer> curr, int n, int k) {
        if (n == 0 && k == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (n == 0 || k == 0)
            return;

        for (int i = start; i < 10; i++) {
            curr.add(i);
            fun(i + 1, curr, n - i, k - 1);
            curr.remove(curr.size() - 1);
        }
    }
}
