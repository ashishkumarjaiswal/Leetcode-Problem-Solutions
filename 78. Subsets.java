class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>());
        for (int i=0;i<nums.length;i++) {
            int n=ret.size();
            for (int j = 0; j < n; j++) {
                List<Integer> temp = new ArrayList<>(ret.get(j));
                temp.add(nums[i]);
                ret.add(temp);
            }
        }
        return ret;
    }
}
//By Recurssion
class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        fun(nums, 0, new ArrayList<>());
        return result;
    }

    void fun(int[] nums, int ind, List<Integer> list) {
        if (ind == nums.length) {
            result.add(list);
            return;
        }
        list.add(nums[ind]);
        //is come
        fun(nums, ind + 1, new ArrayList<>(list));
        list.remove(list.size() - 1);
        //not come
        fun(nums, ind + 1, new ArrayList<>(list));
    }
}
