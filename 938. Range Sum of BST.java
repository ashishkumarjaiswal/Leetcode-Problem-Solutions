class Solution {
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        fun(root, low, high);
        return sum;
    }

    void fun(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.val <= high && root.val >= low)
            sum = sum + root.val;
        if (root.val > low) {
            fun(root.left, low, high);
        }
        if (root.val < high)
            fun(root.right, low, high);
    }
}
