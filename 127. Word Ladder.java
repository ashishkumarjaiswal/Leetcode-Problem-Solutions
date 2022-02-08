class Solution {
    HashMap<String, Boolean> map = new HashMap<>();
    Queue<String> q = new LinkedList<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            map.put(wordList.get(i), false);
        }
        q.add(beginWord);
        map.put(beginWord, true);
        int count = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.poll();
                if (s.equals(endWord))
                    return count;
                fun(s);
            }
            count++;
        }
        return 0;
    }

    void fun(String s) {
        for (int i = 0; i < s.length(); i++) {
            char[] arr = s.toCharArray();
            for (int j = 0; j < 26; j++) {
                char c = (char) ('a' + j);
                arr[i] = c;
                String temp = String.valueOf(arr);
                if (map.containsKey(temp) && !map.get(temp)) {
                    q.add(temp);
                    map.put(temp, true);
                }
            }
        }
    }
}
