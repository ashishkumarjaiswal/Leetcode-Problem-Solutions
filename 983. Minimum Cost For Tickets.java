class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        return fun(costs, days, 0, new int[days.length]);
    }

    int fun(int[] costs, int[] days, int i, int[] dp) {
        if (i >= days.length) {
            return 0;
        }

        if (dp[i] > 0) {
            return dp[i];
        }

        int dayOne = costs[0] + fun(costs, days, i + 1, dp);

        int index = i;

        while (index < days.length && days[index] < days[i] + 7) {
            index++;
        }
        int dayWeek = costs[1] + fun(costs, days, index, dp);

        index = i;

        while (index < days.length && days[index] < days[i] + 30) {
            index++;
        }

        int dayMonth = costs[2] + fun(costs, days, index, dp);

        return dp[i] = Math.min(dayMonth, Math.min(dayOne, dayWeek));
    }
}
