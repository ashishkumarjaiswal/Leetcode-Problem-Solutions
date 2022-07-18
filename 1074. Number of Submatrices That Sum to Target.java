class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        int count = 0;

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum = 0;

                for (int k = 0; k < matrix.length; k++) {
                    sum += matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);
                    int temp = map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                    count += temp;
                }
            }
        }

        return count;
    }
}
