class Solution {
    public int findKthPositive(int[] arr, int k) {
        int count = 0;
        List<Integer> miss = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            count++;
            while (arr[i] != count) {
                miss.add(count);
                count++;
            }
        }
        count++;
        while (miss.size() < k) {
            miss.add(count++);
        }
        return miss.get(k - 1);
    }
}
