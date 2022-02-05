class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int arr[] = new int[2];
        List<Integer> l = new ArrayList<>();
        l.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                arr[0] = nums[i];
                continue;
            }
            l.add(nums[i]);
        }
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) != i + 1) {
                arr[1] = i + 1;
                break;
            }
        }
        if (arr[1] == 0)
            arr[1] = nums.length;

        return arr;
    }
}
