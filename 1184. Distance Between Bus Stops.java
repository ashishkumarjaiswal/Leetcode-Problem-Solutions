class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;
        int n = distance.length;
        for (int i = start; i % n != destination; i++) {
            sum = sum + distance[i % n];
        }
        int total = 0;
        for (int i = 0; i < distance.length; i++) {
            total += distance[i];
        }
        return Math.min(sum, total - sum);
    }
}
