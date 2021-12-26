class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] p2, int[] p1) {
                return (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[1] * p1[1] + p1[0] * p1[0]);
            }
        });
        for (int i = 0; i < points.length; i++) {
            pq.add(points[i]);
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.remove();
        }
        return ans;
    }
}
