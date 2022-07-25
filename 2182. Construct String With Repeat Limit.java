class Solution {
    class Pair {
        char c;
        int count;

        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> b.c - a.c);
        int[] alphaArr = new int[26];

        for (char c : s.toCharArray()) {
            int i = c - 'a';
            alphaArr[i]++;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (alphaArr[i] != 0)
                q.add(new Pair((char) (i + 'a'), alphaArr[i]));
        }

        while (!q.isEmpty()) {
            int x = repeatLimit;
            Pair temp = q.poll();

            while (x-- > 0 && temp.count > 0) {
                sb.append(temp.c);
                temp.count--;
            }

            if (!q.isEmpty() && temp.count > 0) {
                sb.append(q.peek().c);
                q.peek().count--;

                if (q.peek().count == 0)
                    q.poll();
            }

            if (temp.count > 0) {
                q.add(temp);
            }

        }

        int count = 1;
        char c = sb.charAt(sb.length() - 1);

        for (int i = sb.length() - 2; i >= 0; i--) {
            if (sb.charAt(i) == c) {
                count++;

                if (count > repeatLimit)
                    sb.deleteCharAt(i);
            } else {
                break;
            }
        }

        return sb.toString();
    }
}
