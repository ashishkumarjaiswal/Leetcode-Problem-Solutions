class Solution {
    public List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < words[0].length(); i++) {
            char c = words[0].charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 1; i < words.length; i++) {
            String s = words[i];
            HashMap<Character, Integer> temp = new HashMap<>();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (map.containsKey(c)) {
                    temp.put(c, temp.getOrDefault(c, 0) + 1);
                    if (map.get(c) == 1)
                        map.remove(c);
                    else
                        map.put(c, map.get(c) - 1);
                }
            }
            map = temp;
        }

        for (char c : map.keySet()) {
            int x = map.get(c);
            while (x-- > 0) {
                ans.add(c + "");
            }
        }
        return ans;
    }
}
