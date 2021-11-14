class CombinationIterator {
    Queue<String> ans;

    public CombinationIterator(String characters, int combinationLength) {
        ans = new LinkedList<>();
        fun(characters, combinationLength, new StringBuilder(),0);
    }

    void fun(String characters, int k, StringBuilder str,int j) {
        if (k == 0) {
            ans.add(str.toString());
            return;
        }
        for (int i = j; i < characters.length(); i++) {
            str.append(characters.charAt(i));
            fun(characters, k - 1, str,i+1);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public String next() {
        return ans.poll();
    }

    public boolean hasNext() {
        return !ans.isEmpty();
    }
}
