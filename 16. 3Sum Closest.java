class Solution {
    public int threeSumClosest(int[] nums, int target) {
        List<Integer> ret = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int val = nums[i];
            List<Integer> temp = two(nums, i + 1, nums.length - 1, val, target);
            for (Integer integer : temp) {
                ret.add(integer);
            }
        }
        Collections.sort(ret);
        System.out.println(ret);
        int i;
        int dis = Integer.MAX_VALUE;
        for (i = 0; i < ret.size(); i++) {
            if (i != 0 && ret.get(i) == ret.get(i - 1))
                continue;
            if (ret.get(i) < target) {
                dis = Math.abs(target - ret.get(i));
                continue;
            } else {
                if (i == 0 || target == ret.get(i))
                    return ret.get(i);
                if (Math.abs(target - ret.get(i)) < dis) {
                    return ret.get(i);
                }
                return ret.get(i-1);
            }
        }
        return ret.get(ret.size() - 1);
    }

    public List<Integer> two(int[] nums, int i, int j, int val, int target) {
        List<Integer> ret = new ArrayList<>();
        int z = i;
        while (i < j) {
            if (i != z && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            int sum = nums[i] + nums[j] + val;
            if (sum < target) {
                ret.add(sum);
                i++;
            } else if (sum == target) {
                ret.add(sum);
                j--;
            } else {
                ret.add(sum);
                j--;
            }

        }
        return ret;
    }
}
