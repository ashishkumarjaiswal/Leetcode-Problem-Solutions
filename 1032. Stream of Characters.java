class StreamChecker {
    class Node {
        Node[] root = new Node[26];
        boolean isEnd = false;
    }

    Node ans = new Node();
    StringBuilder sb = new StringBuilder();

    public StreamChecker(String[] words) {
        for (int i = 0; i < words.length; i++) {
            Node temp = ans;
            String s = words[i];
            for (int j = s.length() - 1; j >= 0; j--) {
                int a = s.charAt(j) - 'a';
                if (temp.root[a] == null) {
                    temp.root[a] = new Node();
                }
                temp = temp.root[s.charAt(j) - 'a'];
            }
            temp.isEnd = true;
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        Node n = ans;
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            n = n.root[c - 'a'];
            if (n != null && n.isEnd)
                return true;
            if (n == null)
                return false;
        }
        return false;
    }
}
