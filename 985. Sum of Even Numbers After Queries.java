class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        int currSum = 0;

        for (int i : nums) {
            if ((i & 1) == 0)
                currSum += i;
        }

        int x = 0;

        for (int[] querie : queries) {
            int val = querie[0];
            int index = querie[1];

            if ((nums[index] & 1) == 0) {
                currSum = currSum - nums[index];
            }

            nums[index] = nums[index] + val;

            if ((nums[index] & 1) == 0)
                currSum += nums[index];

            ans[x++] = currSum;
        }

        return ans;
    }
}
