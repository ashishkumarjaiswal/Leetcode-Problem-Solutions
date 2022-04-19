class Solution {
    public int numberOfWays(String corridor) {
        long ans = 1;
        int total = 0, plant = 0, seat = 0, mod = 1000000007;
        boolean flag = false;

        for (int i = 0; i < corridor.length(); i++) {
            char c = corridor.charAt(i);

            if (c == 'S') {
                total++;
                seat++;
            } else if (seat == 0)
                plant++;

            if (seat == 2) {
                if (flag) {
                    ans = (ans * (plant + 1)) % mod;
                }

                flag = true;
                seat = 0;
                plant = 0;
            }
        }
        return (total > 0 && total % 2 == 0) ? (int) ans : 0;
    }
}
