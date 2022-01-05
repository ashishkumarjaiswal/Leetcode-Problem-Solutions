class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length())
            return new ArrayList<>();
        HashMap<Character, Integer> pmap = new HashMap<>();
        HashMap<Character, Integer> smap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < p.length(); i++) {
            pmap.put(p.charAt(i), pmap.getOrDefault(p.charAt(i), 0) + 1);
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length() - p.length(); i++) {
            if (smap.equals(pmap)) {
                ans.add(i);
            }

            smap.put(s.charAt(i), smap.get(s.charAt(i)) - 1);

            if (smap.get(s.charAt(i)) == 0)
                smap.remove(s.charAt(i));

            smap.put(s.charAt(i + p.length()), smap.getOrDefault(s.charAt(i + p.length()), 0) + 1);
        }
        if (smap.equals(pmap)) {
            ans.add(s.length()-p.length());
        }
        return ans;
    }
}
