class Solution {
    public int countPoints(String rings) {
        int count = 0;
        HashMap<Integer, HashSet<Character>> map = new HashMap<>();
        for (int i = 0; i < rings.length(); i = i + 2) {
            int num = rings.charAt(i + 1) - 48;
            char c = rings.charAt(i);
            if (!map.containsKey(num))
                map.put(num, new HashSet<>());
            map.get(num).add(c);
        }
        for (int i : map.keySet()) {
            if (map.get(i).size() == 3)
                count++;
        }
        return count;
    }
}
