// By Looping
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        int[] arr = new int[nums1.length];
        for (int i = 0; i < arr.length; i++) {
            int x = map.get(nums1[i]);
            int max = -1;
            for (int j = x + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    max = nums2[j];
                    break;
                }
            }
            arr[i] = max;
        }
        return arr;
    }
}
