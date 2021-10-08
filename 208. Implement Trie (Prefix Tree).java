class Trie {
    class node {
        node[] arr = new node[26];
        boolean present;
    }

    final node root;

    public Trie() {
        root = new node();
    }

    public void insert(String word) {
        node c = root;
        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            if (c.arr[a - 'a'] == null) {
                c.arr[a - 'a'] = new node();
            }
            c = c.arr[a - 'a'];
        }
        c.present = true;

    }

    public boolean search(String word) {
        node c = root;
        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            if (c.arr[a - 'a'] == null)
                return false;
            c = c.arr[a - 'a'];
        }
        return c.present;
    }

    public boolean startsWith(String prefix) {
        node c = root;
        for (int i = 0; i < prefix.length(); i++) {
            char a = prefix.charAt(i);
            if (c.arr[a - 'a'] == null)
                return false;
            c = c.arr[a - 'a'];
        }
        return true;
    }
}
