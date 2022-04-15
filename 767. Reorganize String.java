class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int max = 0;

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            max = Math.max(max, map.get(c));
        }

        if ((len & 1) == 0) {
            if (max > len / 2)
                return "";
        } else {
            if (max > (len / 2) + 1)
                return "";
        }

        PriorityQueue<Character> q = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        char[] arr = new char[s.length()];
        int i = 0, j = 1;

        for (char c : map.keySet()) {
            q.add(c);
        }

        while (!q.isEmpty()) {
            char c = q.poll();
            while (i < len && map.get(c) > 0) {
                arr[i] = c;
                i = i + 2;
                map.put(c, map.get(c) - 1);
            }

            while (i >= len && map.get(c) > 0) {
                arr[j] = c;
                j = j + 2;
                map.put(c, map.get(c) - 1);
            }
        }
        return String.valueOf(arr);
    }
}
