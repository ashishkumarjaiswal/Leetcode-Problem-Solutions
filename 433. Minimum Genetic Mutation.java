class Solution {
    Queue<String> q = new LinkedList<>();
    HashMap<String, Integer> already = new HashMap<>();

    public int minMutation(String start, String end, String[] bank) {
        int curr = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : bank) {
            map.put(s, 1);
        }
        q.add(start);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String x = q.poll();
                if (x.equals(end))
                    return curr;
                charChange(x, map);
            }
            curr++;
        }
        return -1;
    }

    void charChange(String s, HashMap<String, Integer> map) {
        if (already.containsKey(s))
            return;

        already.put(s, 1);

        for (int i = 0; i < 8; i++) {
            char[] arr = s.toCharArray();
            for (int j = 0; j < 26; j++) {
                arr[i] = (char) ('A' + j);
                if (map.containsKey(String.valueOf(arr))) {
                    q.add(String.valueOf(arr));
                }
            }
        }
    }
}
