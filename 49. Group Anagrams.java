class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String a = new String(c);
            if (map.containsKey(a)) {
                map.get(a).add(strs[i]);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(a, temp);
            }
        }
        // List<String> ashish = new ArrayList<>(map.keySet());
        // for (int i = 0; i < ashish.size(); i++) {
        // System.out.println(ashish.get(i));
        // }
        for (String i : map.keySet()) {
            result.add(map.get(i));
        }
        return result;
    }
}
