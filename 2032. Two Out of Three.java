class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        HashMap<Integer, Integer> map3 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i], 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            map2.put(nums2[i], 1);
        }
        for (int i = 0; i < nums3.length; i++) {
            map3.put(nums3[i], 1);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (map2.containsKey(nums1[i]))
                set.add(nums1[i]);
            else if (map3.containsKey(nums1[i]))
                set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map1.containsKey(nums2[i]))
                set.add(nums2[i]);
            else if (map1.containsKey(nums2[i]))
                set.add(nums2[i]);
        }
        for (int i = 0; i < nums3.length; i++) {
            if (map1.containsKey(nums3[i]))
                set.add(nums3[i]);
            else if (map2.containsKey(nums3[i]))
                set.add(nums3[i]);
        }
        for (int i : set) {
            ans.add(i);
        }
        return ans;
    }
}
