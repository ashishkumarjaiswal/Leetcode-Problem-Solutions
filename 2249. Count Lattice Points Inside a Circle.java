class Solution {
    public int countLatticePoints(int[][] circles) {
        int count = 0;

        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= 200; j++) {
                for (int[] circle : circles) {
                    int x = circle[0];
                    int y = circle[1];
                    int r = circle[2];

                    if (((x - i) * (x - i)) + ((y - j) * (y - j)) <= r * r) {
                        count++;
                        break;
                    }
                }
            }
        }

        return count;
    }
}
