class Solution {
    public boolean isValid(String s) {
        Stack<Character> a = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                a.push(s.charAt(i));
            } else {
                if (a.size() == 0) {
                    return false;
                } else if (s.charAt(i) == ')') {
                    if (a.pop() != '(')
                        return false;
                } else if (s.charAt(i) == ']') {
                    if (a.pop() != '[')
                        return false;
                } else if (s.charAt(i) == '}') {
                    if (a.pop() != '{')
                        return false;
                }
            }
        }
        if (a.size() == 0) {
            return true;
        }
        return false;
    }
}
