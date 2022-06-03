class Solution {
    public int numberOfWeakCharacters(int[][] arr) {
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        int count = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i][1] < max) {
                count++;
            }

            max = Math.max(max, arr[i][1]);
        }

        return count;
    }
}
