class Solution {
    public int compress(char[] chars) {
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            int count = 1;
            int j = i + 1;
            while (j < chars.length && chars[i] == chars[j]) {
                j++;
                count++;
            }
            if (count == 1) {
                chars[index++] = chars[i];
            } else {
                chars[index++] = chars[i];
                String s = "" + (count);
                for (int k = 0; k < s.length(); k++) {
                    chars[index++] = s.charAt(k);
                }
            }
            i = j - 1;
        }

        return index;
    }
}
