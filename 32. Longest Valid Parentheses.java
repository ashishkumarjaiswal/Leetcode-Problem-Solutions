class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> par = new Stack<>();
        Stack<Integer> index = new Stack<>();
        index.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                par.push(c);
                index.push(i);
            } else {
                if (!par.isEmpty()) {
                    index.pop();
                    par.pop();
                    max = Math.max(i - index.peek(), max);
                } else {
                    index.push(i);
                }
            }
        }
        return max;
    }
}
