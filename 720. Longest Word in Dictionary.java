class Solution {
    class Node {
        Node[] arr = new Node[26];
        boolean isEnd = false;
    }

    Node root = new Node();

    public String longestWord(String[] words) {
        int max = 0;
        String ans = "";
        Arrays.sort(words, (x, y) -> x.length() - y.length());

        for (int i = 0; i < words.length; i++) {
            int x = insert(words[i]);
            if (x == 1)
                continue;

            if (x >= max) {
                if (x == max) {
                    ans = fun(ans, words[i]);
                } else {
                    ans = words[i];
                }
                max = x;
            }
        }

        return ans;
    }

    String fun(String one, String two) {
        for (int i = 0; i < one.length(); i++) {
            if (one.charAt(i) < two.charAt(i)) {
                return one;
            } else if (one.charAt(i) > two.charAt(i)) {
                return two;
            }
        }
        return one;
    }

    int insert(String s) {
        Node head = root;
        int len = 1;

        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';

            if (head.arr[x] == null) {
                head.arr[x] = new Node();
            }

            head = head.arr[x];

            if (i != s.length() - 1 && !head.isEnd)
                return len;

            len++;
        }
        head.isEnd = true;
        return len;

    }
}
