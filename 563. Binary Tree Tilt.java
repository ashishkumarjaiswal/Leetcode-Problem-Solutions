//Using Class and Object
class Solution {
    public int findTilt(TreeNode root) {
        if (root == null)
            return 0;
        pair x = sumDiff(root.left);
        pair y = sumDiff(root.right);
        int diff = Math.abs(x.sum - y.sum);
        return ans + diff;
    }

    class pair {
        int sum = 0;
        int diff = 0;
    }

    int ans = 0;

    pair sumDiff(TreeNode root) {
        if (root == null)
            return new pair();
        pair left = sumDiff(root.left);
        pair right = sumDiff(root.right);
        pair curr = new pair();
        curr.sum = root.val + left.sum + right.sum;
        curr.diff = Math.abs(left.sum - right.sum);
        ans = ans + curr.diff;
        return curr;
    }

    int fun(TreeNode root) {
        if (root == null)
            return 0;

        int sum = fun(root.left) + fun(root.right) + root.val;
        return sum;
    }
}
