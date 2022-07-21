class Solution {
    HashSet<String> set;
    int ans;

    public int maxUniqueSplit(String s) {
        set = new HashSet<>();
        ans = 0;
        fun(s, 0);
        return ans;
    }

    void fun(String s, int curr) {
        if (s.length() == 0) {
            ans = Math.max(ans, curr);
        }

        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);

            if (!set.contains(sub)) {
                set.add(sub);
                fun(s.substring(i + 1), curr + 1);
                set.remove(sub);
            }
        }
    }
}
