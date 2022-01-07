class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> cmap = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            cmap.put(chars.charAt(i), cmap.getOrDefault(chars.charAt(i), 0) + 1);
        }
        int count = 0;
        for (String s : words) {
            HashMap<Character, Integer> map = new HashMap<>();
            boolean flag = false;
            map.putAll(cmap);
            for (int i = 0; i < s.length(); i++) {
                if (!map.containsKey(s.charAt(i))) {
                    flag = true;
                    break;
                }
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) == -1) {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                count = count + s.length();
        }
        return count;
    }
}
