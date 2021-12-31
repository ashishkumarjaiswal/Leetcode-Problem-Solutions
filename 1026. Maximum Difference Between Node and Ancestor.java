class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return minMax(root, root.val, root.val);
    }

    int minMax(TreeNode root, int min, int max) {
        if (root == null) {
            return max - min;
        }

        int a = minMax(root.left, Math.min(min, root.val), Math.max(max, root.val));
        int b = minMax(root.right, Math.min(min, root.val), Math.max(max, root.val));
        return Math.max(a, b);
    }
}
