class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0, costSum = 0, ind = 0, minVal = Integer.MAX_VALUE, temp = 0;
        for (int i = 0; i < cost.length; i++) {
            //Find the Prefix array's min val 
            temp = temp + gas[i] - cost[i];
            if (temp < minVal) {
                ind = i;
                minVal = temp;
            }
            //Find Total Sum of cost
            costSum = costSum + cost[i];
            //Find Total Sum of gas
            gasSum = gasSum + gas[i];
        }
        if (gasSum < costSum)
            return -1;
        if (ind == gas.length - 1)
            return 0;
        return (ind + 1);
    }
}


class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0, costSum = 0, temp = 0, min = Integer.MAX_VALUE, ind = 0;
        for (int i = 0; i < cost.length; i++) {
            costSum = costSum + cost[i];
            gasSum = gasSum + gas[i];
            temp = temp + gas[i] - cost[i];
            if (temp < min) {
                min = temp;
                ind = i;
            }
        }
        if (gasSum < costSum)
            return -1;
        return ((ind + 1) % gas.length);
    }
}
