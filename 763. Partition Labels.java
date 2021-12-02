class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        while (start < s.length()) {
            map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
            end++;
            while (start < s.length() && map.get(s.charAt(start)) <= 0 && start != end) {
                start++;
            }
            if (start == end) {
                ans.add(start);
            }
            if (end >= s.length())
                break;
        }
        result.add(ans.get(0));
        for (int i = 1; i < ans.size(); i++) {
            result.add(ans.get(i) - ans.get(i - 1));
        }
        return result;
    }
}
