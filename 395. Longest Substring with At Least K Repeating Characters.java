class Solution {
    public int longestSubstring(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        boolean flag = true;
        int len = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int a = map.get(s.charAt(i));
            if (a < k) {
                String sub = s.substring(start, i);
                len = Math.max(len, longestSubstring(sub, k));
                flag = false;
                start = i + 1;
            }
        }
        if (flag)
            return s.length();
        return Math.max(len, longestSubstring(s.substring(start), k));
    }
}
