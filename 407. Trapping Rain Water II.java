import java.util.*;

class Solution {
    public class Pair implements Comparable<Pair> {
        int row;
        int col;
        int height;;

        Pair(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }

        public int compareTo(Pair x) {
            return this.height - x.height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<Pair> q = new PriorityQueue<>();

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    visited[i][j] = true;
                    q.add(new Pair(i, j, heightMap[i][j]));
                }
            }
        }

        int water = 0;
        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (!q.isEmpty()) {
            Pair x = q.poll();

            for (int[] dir : directions) {
                int row = dir[0] + x.row;
                int col = dir[1] + x.col;

                if (isValid(col, row, heightMap) && !visited[row][col]) {
                    water = water + Math.max(0, x.height - heightMap[row][col]);
                    visited[row][col] = true;

                    if (x.height > heightMap[row][col]) {
                        q.add(new Pair(row, col, x.height));
                    } else {
                        q.add(new Pair(row, col, heightMap[row][col]));
                    }

                }
            }
        }

        return water;
    }

    boolean isValid(int col, int row, int[][] height) {
        if (row < 0 || col < 0 || row >= height.length || col >= height[0].length)
            return false;

        return true;
    }
}
