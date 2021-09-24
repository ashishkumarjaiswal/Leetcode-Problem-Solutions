class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length < 3)
            return ret;
        int val = nums[0];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == val)
                continue;
            val = nums[i];
            int target = 0 - (val);
            List<List<Integer>> res = twosum(target, nums, i + 1, val, nums.length - 1);
            for (int j = 0; j < res.size(); j++) {
                ret.add(res.get(j));
            }
        }
        return ret;
    }

    public List<List<Integer>> twosum(int target, int[] nums, int i, int val, int j) {
        List<List<Integer>> ret = new ArrayList<>();
        int b = i;
        while (i < j) {
            if (i != b && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }

            int sum = nums[i] + nums[j];
            if (target == sum) {
                List<Integer> a = new ArrayList<>();
                a.add(val);
                a.add(nums[i]);
                a.add(nums[j]);
                ret.add(a);
                i++;
                j--;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return ret;
    }
}
