class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Integer[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int max = Integer.MIN_VALUE;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            Integer[] temp = new Integer[3];
            temp[0] = nums.get(i).get(0);
            temp[1] = 0;
            temp[2] = i;
            max = Math.max(max, temp[0]);

            q.add(temp);
        }

        int[] range = { -100000, 100000 };

        while (true) {
            Integer[] temp = q.poll();

            if (max - temp[0] < ans) {
                ans = max - temp[0];
                range = new int[] { temp[0], max };
            }

            temp[1]++;
            List<Integer> curr = nums.get(temp[2]);

            if (curr.size() == temp[1])
                break;

            Integer[] x = { curr.get(temp[1]), temp[1], temp[2] };
            max = Math.max(max, x[0]);
            q.add(x);

        }

        return range;
    }
}
