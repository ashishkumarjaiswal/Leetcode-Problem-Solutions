class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        int start = 1, end = 0;
        fun(ret, n, start, end, "(");
        return ret;
    }

    public void fun(List<String> ret, int n, int start, int end, String s) {
        if (s.length() == 2 * n) {
            ret.add(s);
            return;
        }
        if (start < n) {
            fun(ret, n, start + 1, end, s + "(");
        }
        if (start > end) {
            fun(ret, n, start, end + 1, s + ")");
        }

    }
}
