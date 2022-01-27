class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.right != null && root.left != null)
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        else
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
