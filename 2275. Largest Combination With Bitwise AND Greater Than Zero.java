class Solution {
    public int largestCombination(int[] candidates) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < candidates.length; j++) {
                if ((candidates[j] & (1 << i)) > 0)
                    count++;
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }
}
