class Solution {
    public int countPrefixes(String[] words, String s) {
        int count = 0;

        for (String word : words) {
            int len = word.length();

            if (len <= s.length() && s.substring(0, len).equals(word)) {
                count++;
            }
        }

        return count;
    }
}
