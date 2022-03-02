class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((arr1, arr2) -> arr1[0] + arr1[1] - arr2[0] - arr2[1]);

        for (int i = 0; i < nums1.length; i++) {
            q.add(new int[] { nums1[i], nums2[0], 0 });
        }

        while (k-- > 0 && !q.isEmpty()) {
            int[] temp = q.poll();
            ans.add(List.of(temp[0], temp[1]));
            if (temp[2] + 1 < nums2.length) {
                q.add(new int[] { temp[0], nums2[temp[2] + 1], temp[2] + 1 });
            }
        }

        return ans;
    }
}
