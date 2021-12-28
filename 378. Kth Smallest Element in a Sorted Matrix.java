//Using PriorityQueue
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int[] is : matrix) {
            for (int i : is) {
                q.add(i);
            }
        }
        while (k-- > 1) {
            q.remove();
        }
        return q.remove();
    }
}
