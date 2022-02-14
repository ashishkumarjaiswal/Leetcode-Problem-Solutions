class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int max = 0;
        int temp = 0;
        int total = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            temp = temp + satisfaction[i];
            max = max + temp;
            if (max > total)
                total = max;
        }
        return total;
    }
}
