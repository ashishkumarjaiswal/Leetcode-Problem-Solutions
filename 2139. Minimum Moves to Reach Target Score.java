class Solution {
    public int minMoves(int target, int maxDoubles) {
        if (maxDoubles == 0)
            return target - 1;
        int count = 0;

        int x = target;

        while (x > 1 && maxDoubles > 0) {
            if (x % 2 != 0) {
                count += 2;
            } else {
                count++;
            }
            x = x >> 1;
            maxDoubles--;
        }
        count = count + x - 1;
        return count;
    }
}
