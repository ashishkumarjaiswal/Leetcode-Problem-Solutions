class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, 1);
        }
        while (map.containsKey(original)) {
            original = original * 2;
        }
        return original;
    }
}
