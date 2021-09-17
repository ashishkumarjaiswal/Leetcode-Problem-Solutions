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
