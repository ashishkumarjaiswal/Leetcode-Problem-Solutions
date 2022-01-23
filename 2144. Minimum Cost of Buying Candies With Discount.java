class Solution {
    public int minimumCost(int[] cost) {
        if (cost.length == 1) {
            return cost[0];
        }
        if (cost.length == 2) {
            return cost[0]+cost[1];
        }
        Arrays.sort(cost);
        int totalCost = 0, ind = 1;
        for (int i = cost.length - 2; i >= 0; i = i - 3) {
            totalCost += cost[i] + cost[i + 1];
            ind = i;
        }
        if (cost.length % 3 == 0)
            return totalCost;
        for (int i = 0; i < ind - 1; i++) {
            totalCost += cost[i];
        }
        return totalCost;
    }
}
