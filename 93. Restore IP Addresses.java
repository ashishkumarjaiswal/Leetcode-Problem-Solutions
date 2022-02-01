class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        fun(0, 0, s, "");
        return ans;
    }

    void fun(int i, int partition, String s, String curr) {
        if (partition == 4 || i == s.length()) {
            if (partition == 4 && s.length() == i) {
                ans.add(curr.substring(0, curr.length() - 1));
            }
            return;
        }

        fun(i + 1, partition + 1, s, curr + s.charAt(i) + ".");

        if (s.length() >= 2 + i && valid(s.substring(i, i + 2)))
            fun(i + 2, partition + 1, s, curr + s.substring(i, i + 2) + ".");

        if (s.length() >= 3 + i && valid(s.substring(i, i + 3)))
            fun(i + 3, partition + 1, s, curr + s.substring(i, i + 3) + ".");
    }

    boolean valid(String s) {
        if (s.charAt(0) == '0')
            return false;
        return Integer.parseInt(s) <= 255;
    }
}
