//Without dynamic programming only backtracking
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        fun(nums, target, 0);
        return count;
    }

    int count = 0;

    void fun(int[] nums, int target, int start) {
        if (start == nums.length) {
            if (target == 0)
                count++;
            return;
        }
        fun(nums, target + nums[start], start + 1);
        fun(nums, target - nums[start], start + 1);
    }
}
//using both dynamic programming and backtracking
class Solution {
    HashMap<String, Integer> map = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return fun(nums, target, 0, 0);
    }

    int fun(int[] nums, int target, int start, int count) {
        if (map.containsKey(target + " " + start))
            return map.get(target + " " + start);
        if (start == nums.length) {
            if (target == 0)
                count++;
            return count;
        }
        int x = fun(nums, target + nums[start], start + 1, 0);
        int y = fun(nums, target - nums[start], start + 1, 0);
        map.put(target + " " + start, x + y);
        return x + y;
    }
}
