class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int i : nums) {
            arr.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            fun(new ArrayList<>(arr), i, new ArrayList<>(), nums.length);
        }
        return res;
    }

    void fun(List<Integer> arr, int i, List<Integer> list, int size) {
        list.add(arr.get(i));
        arr.remove(i);
        if (list.size() == size) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < arr.size(); j++) {
            fun(new ArrayList<>(arr), j, new ArrayList<>(list), size);
        }

    }
}
