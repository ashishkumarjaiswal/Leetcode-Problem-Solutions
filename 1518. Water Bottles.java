class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int empty = numBottles;
        int count = numBottles;

        while (empty >= numExchange) {
            count = count + empty / numExchange;
            empty = (empty % numExchange) + (empty / numExchange);
        }

        return count;
    }
}
