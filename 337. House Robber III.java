class Solution {
    public int rob(TreeNode root) {
        int[] arr = fun(root);
        return Math.max(arr[0], arr[1]);
    }

    int[] fun(TreeNode root) {
        if (root == null)
            return new int[2];
        int[] left = fun(root.left);
        int[] right = fun(root.right);
        int ans[] = new int[2];
        ans[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        ans[1] = left[0] + right[0] + root.val;
        return ans;
    }
}
