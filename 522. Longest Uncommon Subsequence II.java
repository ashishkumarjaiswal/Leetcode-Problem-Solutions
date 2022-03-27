class Solution {
    public int findLUSlength(String[] strs) {
        int len = -1;
        for (int i = 0; i < strs.length; i++) {
            boolean flag = true;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && subs(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                len = Math.max(len, strs[i].length());
            }
        }
        return len;
    }

    boolean subs(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length()) {
            while (j < b.length() && a.charAt(i) != b.charAt(j)) {
                j++;
            }
            if (j == b.length())
                return false;
            i++;
            j++;
        }
        if (i == a.length())
            return true;
        return false;
    }
}
