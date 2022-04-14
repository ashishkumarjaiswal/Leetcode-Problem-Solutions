class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        HashMap<Long, Integer>[] map = new HashMap[nums.length];
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            map[i] = new HashMap<>();
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                long cd = (long) nums[i] - (long) nums[j];

                if (cd < Integer.MIN_VALUE || cd > Integer.MAX_VALUE)
                    continue;

                int endOnI = map[i].getOrDefault(cd, 0);
                int endOnJ = map[j].getOrDefault(cd, 0);

                ans = ans + endOnJ;
                map[i].put(cd, endOnI + endOnJ + 1);
            }
        }
        return ans;
    }
}
