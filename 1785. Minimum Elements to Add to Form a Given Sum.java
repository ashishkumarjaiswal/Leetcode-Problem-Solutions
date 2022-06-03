class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long total = 0;

        for (int i : nums) {
            total = total + i;
        }

        if (goal == total)
            return 0;

        long diff = Math.abs(total - goal);

        if (diff % limit == 0)
            return (int) (diff / limit);

        return (int) ((diff / limit) + 1);

    }
}
