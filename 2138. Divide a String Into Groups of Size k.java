class Solution {
    public String[] divideString(String s, int k, char fill) {
        String[] arr = new String[s.length() % k == 0 ? s.length() / k : (s.length() / k) + 1];
        for (int i = k; i <= s.length(); i = i + k) {
            arr[(i / k) - 1] = s.substring(i - k, i);
        }
        if (arr[arr.length - 1] == null) {
            String p = s.substring((s.length() / k) * k);
            while (p.length() < k) {
                p = p + fill;
            }
            arr[arr.length - 1] = p;
        }
        return arr;
    }
}
