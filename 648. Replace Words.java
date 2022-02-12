class Solution {
    class Node {
        Node[] arr = new Node[26];
        boolean isEnd = false;
    }

    Node root = new Node();

    public String replaceWords(List<String> dictionary, String sentence) {
        for (int i = 0; i < dictionary.size(); i++) {
            insert(dictionary.get(i));
        }

        String[] splitarr = sentence.split(" ");
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < splitarr.length; i++) {
            String temp = search(splitarr[i]);

            if (temp.length() == 0) {
                ans = ans.append(splitarr[i] + " ");
            } else {
                ans = ans.append(temp + " ");
            }
        }

        return ans.toString().substring(0, ans.length() - 1);
    }

    String search(String s) {
        Node head = root;
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            temp = temp.append(s.charAt(i));

            if (head.arr[x] == null) {
                return "";
            }
            head = head.arr[x];

            if (head.isEnd) {
                return temp.toString();
            }

        }

        return "";
    }

    void insert(String s) {
        Node head = root;

        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';

            if (head.arr[x] == null) {
                head.arr[x] = new Node();
            }
            head = head.arr[x];
        }
        head.isEnd = true;
    }
}
