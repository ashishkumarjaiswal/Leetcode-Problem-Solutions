class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> n1 = new HashMap<>();
        HashMap<Integer, Integer> n2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (n1.getOrDefault(nums1[i], 0) == 0) {
                n1.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (n2.getOrDefault(nums2[i], 0) == 0) {
                n2.put(nums2[i], 1);
            }
        }
        List<Integer> ashish = new ArrayList<>(n1.keySet());
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < ashish.size(); i++) {
            if (n2.getOrDefault(ashish.get(i), 0) == 1)
                a.add(ashish.get(i));
        }
        int[] res = new int[a.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = a.get(i);
        }
        return res;
    }
}
