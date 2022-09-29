class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> greater = new PriorityQueue<>();
        PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < x) {
                smaller.add(arr[i]);
            } else {
                greater.add(arr[i]);
            }
        }

        while (k-- > 0) {
            if (smaller.isEmpty()) {
                ans.add(greater.poll());
                continue;
            }

            if (greater.isEmpty()) {
                ans.add(smaller.poll());
                continue;
            }

            int a = x - smaller.peek();
            int b = greater.peek() - x;

            if (a == b) {
                ans.add(smaller.poll());
            } else if (a < b) {
                ans.add(smaller.poll());
            } else {
                ans.add(greater.poll());
            }
        }

        Collections.sort(ans);

        return ans;
    }
}
