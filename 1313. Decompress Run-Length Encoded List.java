class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i = i + 2) {
            int x = nums[i];
            while (x > 0) {
                x--;
                ans.add(nums[i + 1]);
            }
        }
        int arr[] = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }
        return arr;
    }
}
