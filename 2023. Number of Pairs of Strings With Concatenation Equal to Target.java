class Solution {
    public int numOfPairs(String[] nums, String target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            String s = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (j != i && (s + nums[j]).equals(target))
                    count++;
            }
        }
        return count;
    }
}
