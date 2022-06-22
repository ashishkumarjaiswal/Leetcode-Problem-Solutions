class Solution {
    HashSet<String> set;
    List<List<Integer>> ans;

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        set = new HashSet<>();
        ans = new LinkedList<>();

        for (int[] queen : queens) {
            String key = queen[0] + " " + queen[1];
            set.add(key);
        }

        check(king[0], king[1]);

        return ans;
    }

    void check(int ki, int kj) {
        for (int i = ki + 1; i < 8; i++) {
            String key = i + " " + kj;

            if (set.contains(key)) {
                List<Integer> temp = new LinkedList<>();
                temp.add(i);
                temp.add(kj);
                ans.add(temp);
                break;
            }
        }

        for (int i = ki - 1; i >= 0; i--) {
            String key = i + " " + kj;

            if (set.contains(key)) {
                List<Integer> temp = new LinkedList<>();
                temp.add(i);
                temp.add(kj);
                ans.add(temp);
                break;
            }
        }

        for (int j = kj + 1; j < 8; j++) {
            String key = ki + " " + j;

            if (set.contains(key)) {
                List<Integer> temp = new LinkedList<>();
                temp.add(ki);
                temp.add(j);
                ans.add(temp);
                break;
            }
        }

        for (int j = kj - 1; j >= 0; j--) {
            String key = ki + " " + j;

            if (set.contains(key)) {
                List<Integer> temp = new LinkedList<>();
                temp.add(ki);
                temp.add(j);
                ans.add(temp);
                break;
            }
        }

        for (int i = ki + 1, j = kj + 1; i < 8 && j < 8; i++, j++) {
            String key = i + " " + j;

            if (set.contains(key)) {
                List<Integer> temp = new LinkedList<>();
                temp.add(i);
                temp.add(j);
                ans.add(temp);
                break;
            }
        }

        for (int i = ki + 1, j = kj - 1; i < 8 && j >= 0; i++, j--) {
            String key = i + " " + j;

            if (set.contains(key)) {
                List<Integer> temp = new LinkedList<>();
                temp.add(i);
                temp.add(j);
                ans.add(temp);
                break;
            }
        }

        for (int i = ki - 1, j = kj - 1; i >= 0 && j >= 0; i--, j--) {
            String key = i + " " + j;

            if (set.contains(key)) {
                List<Integer> temp = new LinkedList<>();
                temp.add(i);
                temp.add(j);
                ans.add(temp);
                break;
            }
        }

        for (int i = ki - 1, j = kj + 1; i >= 0 && j < 8; i--, j++) {
            String key = i + " " + j;

            if (set.contains(key)) {
                List<Integer> temp = new LinkedList<>();
                temp.add(i);
                temp.add(j);
                ans.add(temp);
                break;
            }
        }
    }
}
