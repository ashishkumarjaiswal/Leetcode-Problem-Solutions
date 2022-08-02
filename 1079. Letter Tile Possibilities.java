class Solution {
    HashSet<String> set = new HashSet<>();
    boolean[] visited;

    public int numTilePossibilities(String tiles) {
        int n = tiles.length();
        visited = new boolean[n];
        fun(tiles, "");
        return set.size() - 1;
    }

    void fun(String s, String curr) {
        set.add(curr);

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                fun(s, curr + s.charAt(i));
                visited[i] = false;
            }
        }

    }
}
