class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> map = new HashMap<>();

        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                StringBuilder temp = new StringBuilder();
                i++;

                for (; i < s.length(); i++) {
                    if (s.charAt(i) == ')') {
                        break;
                    } else {
                        temp.append(s.charAt(i));
                    }
                }

                if (map.containsKey(temp.toString())) {
                    sb.append(map.get(temp.toString()));
                } else {
                    sb.append('?');
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
