class Solution {
    public int kthSmallest(TreeNode root, int k) {
        fun(root, k);
        return x;
    }

    int count = 0, x = 0;

    void fun(TreeNode root, int k) {
        if (root.left != null) {
            fun(root.left, k);
        }
        count++;
        if (count == k) {
            x = root.val;
            return;
        }
        if (root.right != null){
            fun(root.right, k);
        }
    }
}
