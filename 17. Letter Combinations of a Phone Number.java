class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        Deque<String> ans = new ArrayDeque<>();
        ans.add("");
        HashMap<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        for (int i = 0; i < digits.length(); i++) {
            String y = map.get(digits.substring(i, i + 1));
            int x = ans.size();
            for (int j = 0; j < x; j++) {
                String a = ans.pollFirst();
                for (int j2 = 0; j2 < y.length(); j2++) {
                    ans.add(a + y.substring(j2, j2 + 1));
                }
            }
        }
        while (ans.size() > 0) {
            res.add(ans.poll());
        }
        return res;
    }
}
