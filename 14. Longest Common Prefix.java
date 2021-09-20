class Solution {
    public String longestCommonPrefix(String[] strs) {
        int count = 0;
        String ashish = new String();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < min) {
                min = strs[i].length();
                ashish = new String(strs[i]);
            }
        }
        for (int i = 0; i < min; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (ashish.charAt(i) != strs[j].charAt(i))
                    return ashish.substring(0, count);
            }
            count++;
        }
        return ashish.substring(0, count);
    }
}
