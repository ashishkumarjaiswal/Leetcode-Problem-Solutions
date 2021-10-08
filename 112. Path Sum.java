class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int count = 0;
        return fun(root, targetSum);
    }

    public boolean fun(TreeNode root, int target) {
        if (root == null)
           return false;
        if (root.right == null && root.left == null)
            return (target - root.val) == 0;
        return (fun(root.left, target - root.val) || fun(root.right, target - root.val));
    }
}
