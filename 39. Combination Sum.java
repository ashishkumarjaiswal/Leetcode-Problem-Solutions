class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        fun(candidates, target, 0, new ArrayList<>());
        return res;
    }

    public void fun(int[] candidates, int target, int start, List<Integer> list) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            fun(candidates, target - candidates[i], i, list);
            list.remove(list.size() - 1);
        }

    }
}
