class Solution {
    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        fun(root);

        if (ans == 0)
            return 0;

        return ans - 1;
    }

    int[] fun(TreeNode root) {
        if (root == null)
            return new int[] { -1111, 0 };

        int left[] = fun(root.left);
        int right[] = fun(root.right);
        int x = root.val;

        int[] arr = new int[3];
        arr[0] = x;
        int total = 0;

        if (x == left[0] && x == right[0]) {
            total = left[1] + right[1] + 1;
            arr[1] = 1 + Math.max(left[1], right[1]);
        } else if (x == left[0]) {
            arr[1] = 1 + left[1];
            total = arr[1];
        } else if (x == right[0]) {
            arr[1] = 1 + right[1];
            total = arr[1];
        } else {
            arr[1] = 1;
            total = arr[1];
        }

        if (total > ans)
            ans = total;

        return arr;
    }
}
