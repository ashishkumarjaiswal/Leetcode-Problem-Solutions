class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 1) {
            List<Integer> x = new ArrayList<>(Arrays.asList(0, 1));
            return x;
        }
        List<Integer> ashish = new ArrayList<>();
        fun(n);
        for (int i = 0; i < ans.size(); i++) {
            ashish.add(Integer.parseInt(ans.get(i), 2));
        }

        return ashish;
    }

    List<String> ans;

    List<String> fun(int n) {
        if (n == 1) {
            List<String> x = new ArrayList<>(Arrays.asList("0", "1"));
            return x;
        }
        List<String> recur = fun(n - 1);
        ans = new ArrayList<>();

        for (int i = 0; i < recur.size(); i++) {
            String s = "0" + recur.get(i);
            ans.add(s);
        }

        for (int i = recur.size() - 1; i >= 0; i--) {
            String s = "1" + recur.get(i);
            ans.add(s);
        }

        return ans;
    }
}
