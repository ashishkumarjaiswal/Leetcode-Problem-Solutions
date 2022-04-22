class Solution {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        fun(root, x);
        int parent = n - (left + right + 1);
        int max = Math.max(Math.max(left, right), parent);

        if (max > (n / 2))
            return true;

        return false;
    }

    int left = 0, right = 0;

    int fun(TreeNode root, int x) {
        if (root == null)
            return 0;

        int formLeft = fun(root.left, x);
        int formRight = fun(root.right, x);

        if (root.val == x) {
            left = formLeft;
            right = formRight;
        }

        return formLeft + formRight + 1;
    }

}
