class Solution {
    int ans = 0, max = 0;

    public int deepestLeavesSum(TreeNode root) {
        fun(root, 0);
        return ans;
    }

    void fun(TreeNode root, int count) {
        if (root == null)
            return;
        count++;
        if (root.left == null && root.right == null) {
            if (count > max) {
                max = count;
                ans = root.val;
            } else if (count == max) {
                ans = ans + root.val;
            } else
                return;
        }
        fun(root.left, count);
        fun(root.right, count);
    }
}
