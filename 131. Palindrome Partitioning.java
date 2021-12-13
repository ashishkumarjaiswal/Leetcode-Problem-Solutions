class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        fun(s, new ArrayList<>());
        return ans;
    }

    void fun(String s, List<String> temp) {
        if (s.length() == 0) {
            ans.add(temp);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String pre = s.substring(0, i + 1);
            String post = s.substring(i + 1);
            if (isPalin(pre)) {
                temp.add(pre);
                fun(post, new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
            }
        }
    }

    boolean isPalin(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
