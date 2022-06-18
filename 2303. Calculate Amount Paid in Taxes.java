class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double ans = 0;
        int prev = 0;

        for (int[] bracket : brackets) {
            int maxIncome = bracket[0];
            int percent = bracket[1];

            int num = maxIncome - prev;

            if (num >= income) {
                double newAns = (income * percent * 1d) / (100 * 1d);
                ans = ans + newAns;
                break;
            }

            ans = ans + (num * percent * 1d) / (100 * 1d);
            income = income - num;

            prev = maxIncome;
        }

        return ans;
    }
}
