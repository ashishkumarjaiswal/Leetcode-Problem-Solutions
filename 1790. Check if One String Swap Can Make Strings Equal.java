class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        HashMap<Character, Integer> one = new HashMap<>();
        HashMap<Character, Integer> two = new HashMap<>();

        int count = 0;
        char a = ' ', b = ' ';

        for (int i = 0; i < s1.length(); i++) {
            one.put(s1.charAt(i), one.getOrDefault(s1.charAt(i), 0) + 1);
            two.put(s2.charAt(i), two.getOrDefault(s2.charAt(i), 0) + 1);

            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }

            if (count > 2)
                return false;
        }

        return one.equals(two);

    }
}
