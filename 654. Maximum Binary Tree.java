class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0)
            return null;
        TreeNode root = new TreeNode();
        int maxIndex = max(nums);
        root.val = nums[maxIndex];
         root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIndex));
         root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIndex + 1, nums.length));
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
