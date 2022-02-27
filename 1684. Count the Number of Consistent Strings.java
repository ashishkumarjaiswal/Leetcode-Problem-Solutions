class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : allowed.toCharArray()) {
            map.put(c, 1);
        }
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            boolean flag = true;
            for (char c : s.toCharArray()) {
                if (!map.containsKey(c)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                count++;
        }
        return count;
    }
}
