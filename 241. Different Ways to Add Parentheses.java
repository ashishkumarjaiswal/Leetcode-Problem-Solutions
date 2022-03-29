class Solution {

    public List<Integer> diffWaysToCompute(String expression) {
        return fun(expression);
 
    }

    List<Integer> fun(String s) {
        List<Integer> curr = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '+' || c == '-' || c == '*') {
                List<Integer> a = fun(s.substring(0, i));
                List<Integer> b = fun(s.substring(i + 1));

                for (int x : a) {
                    for (int y : b) {
                        if (c == '+') {
                            curr.add(x + y);
                        } else if (c == '-') {
                            curr.add(x - y);
                        } else {
                            curr.add(x * y);
                        }
                    }
                }
            }
        }
        if (curr.size() == 0)
            curr.add(Integer.parseInt(s));
        return curr;
    }
}
