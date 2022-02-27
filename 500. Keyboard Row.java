class Solution {
    public String[] findWords(String[] words) {
        HashMap<Character, Integer> map = new HashMap<>();
        String[] arr = { "qwertyuiop", "QWERTYUIOP", "ASDFGHJKL", "asdfghjkl", "zxcvbnm", "ZXCVBNM" };

        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            for (char c : s.toCharArray()) {
                map.put(c, (i / 2) + 1);
            }
        }

        List<String> list = new LinkedList<>();

        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            int count = map.get(s.charAt(0));
            boolean flag = true;

            for (char c : s.toCharArray()) {
                if (count != map.get(c)) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                list.add(s);
        }

        String[] ans = new String[list.size()];
        ans = list.toArray(ans);
        return ans;

    }
}
