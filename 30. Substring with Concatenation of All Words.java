class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        int run = words.length * (words[0].length());
        for (int i = 0; i <= s.length() - run; i++) {
            HashMap<String, Integer> temp = new HashMap<>(map);
            boolean flag = true;
            for (int j = i; j < run + i; j = j + words[0].length()) {
                String ashish = s.substring(j, j + words[0].length());
                if (temp.containsKey(ashish)) {
                    temp.put(ashish, temp.get(ashish) - 1);
                    if (temp.get(ashish) < 0) {
                        flag = false;
                        break;
                    }
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(i);
            }
        }
        return result;
    }
}
