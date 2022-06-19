class Solution {
    class Trie {
        Trie[] arr = new Trie[26];
        List<String> list = new LinkedList<>();
    }

    Trie root;

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans = new LinkedList<>();
        root = new Trie();

        for (String s : products) {
            addWordToTrie(s);
        }

        for (int i = 0; i < searchWord.length(); i++) {
            int c = searchWord.charAt(i) - 'a';
            root = root.arr[c];

            if (root == null) {
                for (int j = i; j < searchWord.length(); j++) {
                    ans.add(Collections.EMPTY_LIST);
                }
                break;
            }

            ans.add(root.list);
        }

        return ans;
    }

    void addWordToTrie(String word) {
        Trie temp = root;

        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';

            if (temp.arr[c] == null) {
                temp.arr[c] = new Trie();
            }

            temp = temp.arr[c];

            if (temp.list.size() < 3)
                temp.list.add(word);

        }
    }
}
