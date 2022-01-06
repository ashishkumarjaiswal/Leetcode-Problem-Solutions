class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return fun(nums);
    }

    TreeNode fun(int[] nums) {
        if (nums.length == 0)
            return null;
        TreeNode root = new TreeNode();
        int maxIndex = max(nums);
        root.val = nums[maxIndex];
        TreeNode left = fun(Arrays.copyOfRange(nums, 0, maxIndex));
        TreeNode right = fun(Arrays.copyOfRange(nums, maxIndex + 1, nums.length));
        root.left = left;
        root.right = right;
        return root;
    }

    int max(int[] arr) {
        int max = -1;
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
