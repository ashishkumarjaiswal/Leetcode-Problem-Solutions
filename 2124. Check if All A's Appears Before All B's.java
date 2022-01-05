class Solution {
    public boolean checkString(String s) {
        boolean a = false;
        for (int i = 0; i < s.length(); i++) {
            if (a) {
                if (s.charAt(i) == 'a')
                    return false;
            }
            if (s.charAt(i) == 'b')
                a = true;
        }
        return true;
    }
}
