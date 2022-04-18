class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int count = 1;
        int n = position.length;
        double[][] arr = new double[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = position[i] * 1d;
            arr[i][1] = ((target - position[i]) * 1d) / speed[i];
        }

        Arrays.sort(arr, (a, b) -> Double.compare(a[0], b[0]));
        double time = arr[n - 1][1];

        for (int i = n - 2; i >= 0; i--) {
            if (time < arr[i][1]) {
                count++;
                time = arr[i][1];
            }
        }

        return count;
    }
}
