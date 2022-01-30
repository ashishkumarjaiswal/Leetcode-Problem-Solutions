class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0)
            return ans;
        String s = "";
        boolean flag = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] + 1) == nums[i + 1]) {
                if (flag) {
                    flag = false;
                    s = s + nums[i];
                }
            } else {
                if (flag) {
                    s = s + nums[i];
                    ans.add(s);
                    s = "";
                    continue;
                }
                s = s + "->" + nums[i];
                flag = true;
                ans.add(s);
                s = "";
            }
        }
        if (flag) {
            s = s + nums[nums.length - 1];
        } else {
            s = s + "->" + nums[nums.length - 1];
        }
        ans.add(s);
        return ans;
    }
}
