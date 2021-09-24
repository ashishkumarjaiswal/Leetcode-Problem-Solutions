class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length < 4)
            return ret;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            int val = nums[i];
            int tar = target - (val);
            List<List<Integer>> res = three(nums, i + 1, nums.length - 1, tar, val);
            for (List<Integer> list : res) {
                ret.add(list);
            }
        }
        return ret;
    }

    public List<List<Integer>> three(int[] nums, int i, int j, int target, int val) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int k = i; k < nums.length - 2; k++) {
            if (k != i && nums[k] == nums[k - 1])
                continue;
            int tar = target - nums[k];
            List<List<Integer>> res = two(nums, k + 1, nums.length - 1, tar, val, nums[k]);
            for (List<Integer> list : res) {
                ret.add(list);
            }
        }
        return ret;
    }

    public List<List<Integer>> two(int[] nums, int i, int j, int target, int val, int aa) {
        List<List<Integer>> ret = new ArrayList<>();
        int m = i;
        while (i < j) {
            if (i != m && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            List<Integer> a = new ArrayList<>();
            int sum = nums[i] + nums[j];
            if (target == sum) {
                a.add(val);
                a.add(aa);
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
