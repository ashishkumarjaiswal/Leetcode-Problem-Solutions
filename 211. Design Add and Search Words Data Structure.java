class WordDictionary {
    public class Node {
        Node[] arr = new Node[26];
        boolean isEnd = false;
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.arr[index] == null)
                curr.arr[index] = new Node();
            curr = curr.arr[index];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Node curr = root;
        return fun(curr, word, 0);
    }

    boolean fun(Node curr, String word, int i) {
        if (curr == null)
            return false;
        if (i == word.length())
            return curr.isEnd;

        int index = word.charAt(i);
        if (index == '.') {
            for (int j = 0; j < 26; j++) {
                if (fun(curr.arr[j], word, i + 1))
                    return true;
            }
        } else {
            if (fun(curr.arr[index - 'a'], word, i + 1))
                return true;
        }
        return false;
    }
}
