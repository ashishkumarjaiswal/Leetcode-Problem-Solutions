class Solution {
    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        fun(root, 0);
        return sum;
    }

    void fun(TreeNode root, int curr) {
        if (root == null)
            return;
        curr = curr * 2 + root.val;
        if (root.left == null && root.right == null)
            sum += curr;
        fun(root.left, curr);
        fun(root.right, curr);
    }
}
