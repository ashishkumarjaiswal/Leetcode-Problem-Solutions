class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i <= s.length() - k; i++) {
            String temp = s.substring(i, i + k);
            set.add(temp);
        }

        return set.size() == Math.pow(2, k);
    }
}
