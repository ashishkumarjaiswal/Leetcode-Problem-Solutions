class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }
        HashMap<Character, Integer> smap = new HashMap<>();
        int i, j;
        String ans = "";
        i = j = 0;
        int tlen = t.length();
        int count = 0;
        boolean flag1, flag2;
        while (true) {
            flag1 = false;
            flag2 = false;
            while (i < s.length() && tlen > count) {
                char c = s.charAt(i);
                smap.put(c, smap.getOrDefault(c, 0) + 1);
                if (smap.get(c) <= tmap.getOrDefault(c, 0))
                    count++;
                i++;
                flag1 = true;
            }
            while (j < i && count == tlen) {
                if (ans.length() == 0 || ans.length() > s.substring(j, i).length())
                    ans = s.substring(j, i);
                char c = s.charAt(j);
                if (smap.get(c) == 1) {
                    smap.remove(c);
                } else {
                    smap.put(c, smap.get(c) - 1);
                }
                if (smap.getOrDefault(c, 0) < tmap.getOrDefault(c, 0)) {
                    count--;
                }
                j++;
                flag2 = true;
            }
            if (!flag1 || !flag2)
                break;
        }
        return ans;
    }
}
