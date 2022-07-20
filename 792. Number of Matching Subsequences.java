class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        HashMap<Character, List<String>> map = new HashMap<>();

        for (String word : words) {
            char c = word.charAt(0);

            if (!map.containsKey(c))
                map.put(c, new LinkedList<>());

            map.get(c).add(word);
        }

        for (char c : s.toCharArray()) {
            if (!map.containsKey(c))
                continue;

            List<String> list = map.get(c);

            map.remove(c);

            for (String one : list) {
                if (one.length() == 1) {
                    count++;
                } else {
                    char x = one.charAt(1);

                    if (!map.containsKey(x))
                        map.put(x, new LinkedList<>());

                    map.get(x).add(one.substring(1));
                }
            }
        }

        return count;
    }
}
