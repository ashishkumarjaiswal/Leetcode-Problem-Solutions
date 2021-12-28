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
//Using Linked List
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        List<Integer> q = new ArrayList<>();
        for (int[] is : matrix) {
            for (int i : is) {
                q.add(i);
            }
        }
        Collections.sort(q);
        return q.get(k - 1);
    }
}
