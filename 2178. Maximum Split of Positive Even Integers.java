class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> ans = new ArrayList<>();
        if (finalSum % 2 != 0)
            return ans;

        HashMap<Long, Integer> map = new HashMap<>();
        long x = 2;

        while (finalSum >= x) {
            finalSum = finalSum - x;
            if (map.containsKey(finalSum)) {
                ans.add(x);
                break;
            }
            map.put(x, 1);
            ans.add(x);
            x = x + 2;
        }
        long y = ans.get(ans.size() - 1);
        ans.remove(ans.size() - 1);
        ans.add(y + finalSum);
        return ans;
    }
}
