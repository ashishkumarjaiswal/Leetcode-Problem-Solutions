class Solution {
    int[] parent;
    int[] rank;

    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];

        for (int i = 0; i < 26; i++) {
            parent[i] = i;
            rank[i]=1;
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int x = find(equation.charAt(0) - 'a');
                int y = find(equation.charAt(3) - 'a');

                if (x == y)
                    return false;
            }
        }

        return true;
    }

    int find(int x) {
        if (parent[x] == x)
            return x;

        int a = find(parent[x]);
        parent[x] = a;
        return a;
    }

    void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px != py)
            if (rank[px] > rank[py]) {
                parent[py] = px;
            } else if (rank[py] > rank[px]) {
                parent[px] = py;
            } else {
                parent[py] = px;
                rank[px]++;
            }
    }
}
