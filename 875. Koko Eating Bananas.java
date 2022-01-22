class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int s = 1, e = piles[piles.length - 1];
        while (s <= e) {
            int mid = (s + e) / 2;
            if (fun(piles, mid) > h) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return s;
    }

    int fun(int[] piles, int speed) {
        int count = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] < speed)
                count++;
            else if (piles[i] % speed == 0)
                count = count + piles[i] / speed;
            else
                count = count + (piles[i] / speed) + 1;
        }
        return count;
    }
}
