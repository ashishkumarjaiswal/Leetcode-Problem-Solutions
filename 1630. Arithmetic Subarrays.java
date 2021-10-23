class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < r.length; i++) {
            int[] arr = new int[r[i] - l[i] + 1];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nums[j + l[i]];
            }
            Arrays.sort(arr);
            boolean flag = true;
            int x = Math.abs(arr[1] - arr[0]);
            for (int j = 1; j < arr.length; j++) {
                if (Math.abs(arr[j] - arr[j - 1])!=x) {
                    flag = false;
                    break;
                }
            }
            ans.add(flag);
        }
        return ans;
    }
}
