class Solution {
    public class Pair {
        int s = -1;
        int l = -1;

        Pair(int s, int l) {
            this.s = s;
            this.l = l;
        }
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int ans = 0;

        for (int i = 0; i < houses.length; i++) {
            Pair x = search(houses[i], heaters);
            int a = x.s == -1 ? Integer.MAX_VALUE : houses[i] - x.s;
            int b = x.l == -1 ? Integer.MAX_VALUE : x.l - houses[i];
            int temp = Math.min(a, b);
            if (temp > ans)
                ans = temp;
        }
        return ans;
    }

    Pair search(int key, int[] heaters) {
        Pair x = new Pair(-1, -1);
        int start = 0, end = heaters.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (heaters[mid] == key) {
                x.s = heaters[mid];
                x.l = heaters[mid];
                break;
            } else if (key < heaters[mid]) {
                x.l = heaters[mid];
                end = mid - 1;
            } else {
                x.s = heaters[mid];
                start = mid + 1;
            }
        }
        return x;
    }
}
