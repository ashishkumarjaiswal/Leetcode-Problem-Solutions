class Solution {
    public int[] findBall(int[][] grid) {
        int[] ans = new int[grid[0].length];

        for (int i = 0; i < grid[0].length; i++) {
            int currPos = i;
            int nextPos = -1;

            for (int j = 0; j < grid.length; j++) {
                nextPos = currPos + grid[j][currPos];

                if (nextPos < 0 || nextPos == grid[0].length || grid[j][currPos] != grid[j][nextPos]) {
                    currPos = -1;
                    break;
                }

                currPos = nextPos;
            }

            ans[i] = currPos;
        }

        return ans;
    }
}
