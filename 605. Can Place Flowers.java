class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1) {
            if (n == 0)
                return true;
            if (flowerbed[0] == 0 && n <= 1)
                return true;
            return false;
        }
        int count = 0;
        for (int i = 0; i < flowerbed.length - 1; i++) {
            if (i == 0) {
                if (flowerbed[0] == 0 && flowerbed[1] == 0) {
                    flowerbed[0] = 1;
                    count++;
                }
                continue;
            }
            if (flowerbed[i] == 0) {
                if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }

        }
        if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0)
            count++;
        if (count >= n)
            return true;
        return false;
    }
}
