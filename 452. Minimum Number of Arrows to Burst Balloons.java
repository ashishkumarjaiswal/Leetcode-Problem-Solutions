class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[1], o2[1])); //Use this method to sort
        int count = 1;
        long end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                count++;
                end = points[i][1];
            }
        }
        return count;
    }
}
