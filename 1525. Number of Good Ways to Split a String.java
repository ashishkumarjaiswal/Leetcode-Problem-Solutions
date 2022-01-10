class Solution {
    public int numSplits(String s) {
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> newMap = new HashMap<>();
        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            newMap.put(c, map.getOrDefault(c, 0) + 1);
            if (map.containsKey(c)) {
                if (map.get(c) == 1)
                    map.remove(c);
                else
                    map.put(c, map.get(c) - 1);
            }
            if (map.keySet().size() == newMap.keySet().size())
                count++;
        }

        return count;
    }
}
