class Solution {
    class Pair implements Comparable<Pair> {
        String s;
        int index;

        Pair(String s, int index) {
            this.s = s;
            this.index = index;
        }

        public int compareTo(Pair b) {
            return this.s.length() == b.s.length() ? this.index - b.index : this.s.length() - b.s.length();
        }
    }

    public String arrangeWords(String text) {
        PriorityQueue<Pair> q = new PriorityQueue<>();

        String[] arr = text.split(" ");

        for (int i = 0; i < arr.length; i++) {
            q.add(new Pair(arr[i], i));
        }

        StringBuilder sb = new StringBuilder();

        sb.append(q.peek().s.substring(0, 1).toUpperCase() + q.poll().s.substring(1) + " ");

        while (!q.isEmpty()) {
            sb.append((q.poll().s + " ").toLowerCase());
        }

        return sb.toString().substring(0, sb.length() - 1);
    }
}
