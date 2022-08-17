class Solution {
    String ans = "";
    HashSet<Integer> set = new HashSet<>();

    public String smallestNumber(String pattern) {
        for (int i = 1; i <= 9; i++) {
            char c = (char) ('0' + i);
            set.add(i);
            fun(c + "", pattern, 0);
            set.remove(i);
        }

        return ans;
    }

    boolean fun(String curr, String pattern, int index) {

        if (curr.length() == pattern.length() + 1) {
            if (ans.length() == 0 || ans.compareTo(curr) == 1) {
                ans = curr;
            }

            return true;
        }
        if ((pattern.charAt(index) == 'I' && curr.charAt(curr.length() - 1) == '9')
                || (pattern.charAt(index) == 'D' && curr.charAt(curr.length() - 1) == '1')) {
            return false;
        }

        if (pattern.charAt(index) == 'I') {
            for (int i = curr.charAt(curr.length() - 1) - '0' + 1; i < 10; i++) {
                if (set.contains(i))
                    continue;

                set.add(i);
                if (fun(curr + i, pattern, index + 1))
                    return true;
                set.remove(i);
            }
        } else {
            for (int i = curr.charAt(curr.length() - 1) - '0' - 1; i > 0; i--) {
                if (set.contains(i))
                    continue;

                set.add(i);
                if (fun(curr + i, pattern, index + 1))
                    return true;
                set.remove(i);
            }
        }

        return false;
    }
}
