class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> matrix = new HashSet<>();

        for (int[] obstacle : obstacles) {
            int x = obstacle[0];
            int y = obstacle[1];

            String key = x + "-" + y;

            matrix.add(key);
        }

        int ans = 0;

        boolean east = false;
        boolean west = false;
        boolean north = true;
        boolean south = false;

        int x = 0, y = 0;

        for (int i : commands) {
            if (i == -1) {
                if (north) {
                    north = false;
                    east = true;
                } else if (south) {
                    south = false;
                    west = true;
                } else if (east) {
                    east = false;
                    south = true;
                } else {
                    west = false;
                    north = true;
                }
            } else if (i == -2) {
                if (north) {
                    north = false;
                    west = true;
                } else if (south) {
                    south = false;
                    east = true;
                } else if (east) {
                    east = false;
                    north = true;
                } else {
                    west = false;
                    south = true;
                }
            } else {
                if (east) {
                    for (int j = 1; j <= i; j++) {
                        String key = (x + 1) + "-" + y;
                        if (matrix.contains(key))
                            break;
                        x += 1;
                    }
                } else if (west) {
                    for (int j = 1; j <= i; j++) {
                        String key = (x - 1) + "-" + y;
                        if (matrix.contains(key))
                            break;
                        x -= 1;
                    }
                } else if (north) {
                    for (int j = 1; j <= i; j++) {
                        String key = x + "-" + (y + 1);
                        if (matrix.contains(key))
                            break;
                        y += 1;
                    }
                } else {
                    for (int j = 1; j <= i; j++) {
                        String key = x + "-" + (y - 1);
                        if (matrix.contains(key))
                            break;
                        y = y - 1;
                    }
                }

                ans = Math.max(ans, x * x + y * y);
            }

        }

        return ans;
    }
}
