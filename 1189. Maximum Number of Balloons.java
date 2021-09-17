class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> ashish = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            if (ashish.getOrDefault(text.charAt(i), 0) == 0) {
                ashish.put(text.charAt(i), 1);
            } else {
                ashish.put(text.charAt(i), ashish.get(text.charAt(i)) + 1);
            }
        }
        int min = Math.min(ashish.getOrDefault('n', 0),
                Math.min(ashish.getOrDefault('b', 0), ashish.getOrDefault('a', 0)));
        int minlo = Math.min(ashish.getOrDefault('l', 0), ashish.getOrDefault('o', 0));
        if (min == 0 || minlo < 2)
            return 0;
        minlo = minlo / 2;
        return Math.min(minlo, min);
    }
}
