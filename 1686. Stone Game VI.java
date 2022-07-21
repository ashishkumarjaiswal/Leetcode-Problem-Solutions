class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int alice = 0, bob = 0, n = aliceValues.length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (b[0] + b[1]) - (a[0] + a[1]));

        for (int i = 0; i < n; i++) {
            q.add(new int[] { aliceValues[i], bobValues[i] });
        }

        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                alice = alice + q.poll()[0];
            } else {
                bob = bob + q.poll()[1];
            }
        }

        if (alice > bob) {
            return 1;
        } else if (alice < bob) {
            return -1;
        }

        return 0;
    }
}
