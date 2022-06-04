class Solution {
    public int convertTime(String current, String correct) {
        String[] one = current.split(":");
        String[] two = correct.split(":");

        int a = Integer.parseInt(one[0]);
        int b = Integer.parseInt(one[1]);
        int c = Integer.parseInt(two[0]);
        int d = Integer.parseInt(two[1]);

        int ans = 0;

        ans = ans + (c - a);
        int diff = 0;

        if (b <= d) {
            diff = d - b;
        } else {
            ans--;
            diff = 60 - b + d;
        }

        while (diff > 0) {
            if (diff >= 15) {
                diff -= 15;
                ans++;
            } else if (diff >= 5) {
                ans++;
                diff -= 5;
            } else {
                ans++;
                diff--;
            }
        }

        return ans;
    }
}
