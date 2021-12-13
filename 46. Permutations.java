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
//Another one
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        fun(nums, visited, new ArrayList<>());
        return ans;
    }

    List<List<Integer>> ans = new ArrayList<>();

    void fun(int[] nums, boolean[] visited, List<Integer> list) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                fun(nums, visited, list);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
