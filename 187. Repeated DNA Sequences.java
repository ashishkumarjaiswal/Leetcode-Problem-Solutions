class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new LinkedList<>();
        Map<String, Integer> map = new TreeMap<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String temp = s.substring(i, i + 10);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        for (String st : map.keySet()) {
            if (map.get(st) > 1)
                ans.add(st);
        }
        return ans;
    }
}
