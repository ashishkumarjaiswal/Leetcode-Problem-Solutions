//By the use of
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> table = new HashMap<>();
        table.put(0, 1);
        int count = 0, psum = 0;
        for (int i = 0; i < nums.length; i++) {
            psum += nums[i];
            int temp = psum - k;
            if (table.containsKey(temp)) {
                count += table.get(temp);
            }
            table.put(psum, table.getOrDefault(psum, 0) + 1);
        }
        return count;
    }
}
