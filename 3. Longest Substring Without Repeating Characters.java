class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        boolean f1 = false, f2 = false;
        int i = 0, j = 0, total = 0;
        while (true) {
            f1 = false;
            f2 = false;
            while (i < s.length()) {
                f1 = true;
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
                i++;
                if (map.get(c) == 2)
                    break;
                if (total < i - j)
                    total = i - j;
            }
            while (i > j) {
                f2 = true;
                char c = s.charAt(j);
                map.put(c, map.get(c) - 1);
                j++;
                if (map.get(c) == 1)
                    break;
            }
            if (f1 == false && f2 == false)
                break;
        }
        return total;
    }
}
