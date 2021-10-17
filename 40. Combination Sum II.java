class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            list.add(candidates[i]);
            fun(candidates, target - candidates[i], i + 1, new ArrayList<>(list));
            // if (list.size() > 0)
            list.remove(list.size() - 1);
        }
    }
}
