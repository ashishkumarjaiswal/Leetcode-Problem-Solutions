class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int start = 0, end = citations.length - 1, n = citations.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (citations[mid] == n - mid)
                return n - mid;
            else if (citations[mid] > n - mid)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return n - start;
    }
}
