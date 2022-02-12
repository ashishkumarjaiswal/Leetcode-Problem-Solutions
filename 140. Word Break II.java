
class Solution {
    public class Node {
        Node arr[] = new Node[26];
        boolean isEnd = false;
    }

    Node root = new Node();
    List<String> ans = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        for (int i = 0; i < wordDict.size(); i++) {
            createTrie(wordDict.get(i));
        }

        recur(s, "");

        return ans;
    }

    void recur(String s, String curr) {
        if (s.length() == 0) {
            ans.add(curr.substring(0, curr.length() - 1));
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            if (search(s.substring(0, i))) {
                recur(s.substring(i), curr + s.substring(0, i) + " ");
            }
        }
    }

    boolean search(String s) {
        if (s.length() == 0) {
            return true;
        }

        Node head = root;

        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - 'a';

            if (head.arr[n] == null)
                return false;

            head = head.arr[n];
        }

        return head.isEnd;
    }

    void createTrie(String s) {

        Node head = root;

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (head.arr[c] == null)
                head.arr[c] = new Node();
            head = head.arr[c];
        }
        head.isEnd = true;
    }
}
