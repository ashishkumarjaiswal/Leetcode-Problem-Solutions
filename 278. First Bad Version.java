public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int s = 1, e = n, m = 0, x = 0;
        while (s <= e) {
            m = s + ((e - s) / 2);
            if (isBadVersion(m)) {
                e = m - 1;
                x = m;
            } else
                s = m + 1;
        }
        return x;
    }
}
