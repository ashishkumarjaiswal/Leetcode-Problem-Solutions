class Solution {
    public int findMaxLength(int[] nums) {
        int sum, res;
        sum = res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                nums[i] = -1;
        }

        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                int val = map.get(sum);
                res = Math.max(res, i - val);

            }

        }
        return res;
    }
}
