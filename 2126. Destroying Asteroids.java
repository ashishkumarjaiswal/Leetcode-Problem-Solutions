class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long ans = mass;
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] <= ans)
                ans += asteroids[i];
            else
                return false;
        }
        return true;
    }
}
