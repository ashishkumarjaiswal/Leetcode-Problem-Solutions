class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];

        int index = 0;

        for (int[] querie : queries) {
            int x = querie[0];
            int y = querie[1];
            int r = querie[2];
            int count = 0;

            for (int[] point : points) {
                int a = point[0];
                int b = point[1];

                if ((x - a) * (x - a) + (y - b) * (y - b) <= r * r)
                    count++;
            }

            ans[index++] = count;
        }

        return ans;
    }
}
