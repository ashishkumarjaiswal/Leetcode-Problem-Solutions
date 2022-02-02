class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length())
            return false;

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }
        
          System.out.println(map);
            System.out.println(map2);


        for (int i = 0; i < s2.length() - s1.length(); i++) {
          
            if (map.equals(map2)) {
                return true;
            }
            char r = s2.charAt(i);
            char c = s2.charAt(i + s1.length());

            map2.put(c, map2.getOrDefault(c, 0) + 1);
            map2.put(r, map2.get(r)-1);

            if (map2.get(r) == 0)
                map2.remove(r);
        }

        if (map.equals(map2)) {
            return true;
        }

        return false;
    }
}
