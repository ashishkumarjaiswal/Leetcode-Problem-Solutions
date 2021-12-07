//Using TreeMap
class Solution {
    public int removeDuplicates(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int index = 0;
        for (int i : map.keySet()) {
            int run = map.get(i);
            int count = 0;
            while (run > 0 && count != 2) {
                nums[index++] = i;
                count++;
                run--;
            }
        }
        return index;
    }
}
