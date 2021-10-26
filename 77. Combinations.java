class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }
        for (int i = 0; i < n; i++) {
            fun(arr, k, i, new ArrayList<>());
        }
        return ans;
    }

    void fun(int[] arr, int k, int x, List<Integer> list) {
        list.add(arr[x]);
        if (list.size() == k) {
            ans.add(list);
            return;
        }
        for (int i = x + 1; i < arr.length; i++) {
            fun(arr, k, i, new ArrayList<>(list));
        }

    }
}
