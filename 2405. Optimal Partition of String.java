class Solution {
    public int partitionString(String s) {
        int count = 1;
        boolean[] arr = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (arr[c - 'a']) {
                count++;
                arr = new boolean[26];
                arr[c - 'a'] = true;
            } else {
                arr[c - 'a'] = true;
            }
        }

        return count;
    }
}
