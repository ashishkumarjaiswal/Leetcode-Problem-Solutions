class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        HashMap<Integer, Integer> a = new HashMap<>();
        for (int i = 0; i < nums4.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int x = nums1[i] + nums2[j];
                a.put(x, a.getOrDefault(x, 0) + 1);
            }
        }
        for (int i = 0; i < nums4.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int x = -(nums3[i] + nums4[j]);
                if (a.containsKey(x)) {
                    count = count + a.get(x);
                }
            }
        }
        return count;
    }
}
