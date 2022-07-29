class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int plantingDay = 0, bollomDay = 0;
        int n = growTime.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = plantTime[i];
            arr[i][1] = growTime[i];
        }

        Arrays.sort(arr, (a, b) -> b[1] - a[1]);

        for (int i = 0; i < n; i++) {
            int p = arr[i][0];
            int g = arr[i][1];

            bollomDay = Math.max(bollomDay, plantingDay + p + g);
            plantingDay = plantingDay + p;
        }

        return bollomDay;
    }
}
