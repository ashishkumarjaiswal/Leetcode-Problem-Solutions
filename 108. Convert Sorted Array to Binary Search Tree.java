class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int start = 0, end = nums.length;
        int mid = (end + start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = fun(nums, 0, mid-1);
        root.right = fun(nums, mid + 1, nums.length - 1);
        return root;
    }

    TreeNode fun(int[] nums, int i, int j) {
        if (i > j)
            return null;
        int mid = (j + i) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = fun(nums, i, mid - 1);
        root.right = fun(nums, mid + 1, j);
        return root;
    }
}
