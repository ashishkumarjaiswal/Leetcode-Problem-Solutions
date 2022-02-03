class Solution {
    public int findCenter(int[][] edges) {
        int[] arr = new int[edges.length + 2];

        for (int[] i : edges) {
            for (int j : i) {
                arr[j]++;
            }
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = i;

        }

        return max;

    }
}
