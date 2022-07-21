class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        int n = word1.length();

        HashMap<Character, Integer> one = new HashMap<>();
        HashMap<Character, Integer> two = new HashMap<>();

        for (int i = 0; i < n; i++) {
            one.put(word1.charAt(i), one.getOrDefault(word1.charAt(i), 0) + 1);
            two.put(word2.charAt(i), two.getOrDefault(word2.charAt(i), 0) + 1);
        }

        if (!one.keySet().equals(two.keySet())) {
            return false;
        }

        List<Integer> a = new LinkedList<>(one.values());
        List<Integer> b = new LinkedList<>(two.values());

        Collections.sort(a);
        Collections.sort(b);

        return a.equals(b);
    }
}
