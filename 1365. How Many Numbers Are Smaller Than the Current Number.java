class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] temp = nums.clone();
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            map.put(nums[i], i);
        }
        int arr[] = new int[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(temp[i]);
        }
        return arr;
    }
}
