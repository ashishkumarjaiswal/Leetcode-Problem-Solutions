class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int max = 0;
        for (int i = 0; i < trips.length; i++) {
            max = Math.max(max, trips[i][2]);
        }
        int[] arr = new int[max + 1];
        for (int[] i : trips) {
            arr[i[1]] += i[0];
            arr[i[2]] -= i[0];

        }
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] + arr[i - 1];
            if (arr[i] > capacity)
                return false;
        }
        if (arr[0] > capacity)
            return false;
        return true;
    }
}
