class Solution {
    public int slidingPuzzle(int[][] board) {
        int directions[][] = { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 3, 1, 5 }, { 2, 4 } };

        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        String initial = "";

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                initial = initial + board[i][j];
            }
        }

        set.add(initial);
        q.add(initial);
        String target = "123450";
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String s = q.poll();

                if (s.equals(target))
                    return level;

                int index = -1;

                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == '0') {
                        index = j;
                        break;
                    }
                }

                int[] dir = directions[index];

                for (int j = 0; j < dir.length; j++) {
                    String newS = fun(s, index, dir[j]);

                    if (!set.contains(newS)) {
                        set.add(newS);
                        q.add(newS);
                    }
                }
            }
            level++;
        }

        return -1;
    }

    String fun(String s, int index, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.setCharAt(index, s.charAt(i));
        sb.setCharAt(i, s.charAt(index));
        return sb.toString();
    }
}
