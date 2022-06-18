class WordFilter {
    HashMap<String, Integer> map = new HashMap<>();

    public WordFilter(String[] words) {
        int index = 0;
        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                for (int j = 0; j <= word.length(); j++) {
                    String s = word.substring(0, i) + "#" + word.substring(j);
                    map.put(s, index);
                }
            }
            index++;
        }
    }

    public int f(String prefix, String suffix) {
        String key = prefix + "#" + suffix;

        if (map.containsKey(key))
            return map.get(key);

        return -1;
    }
}
