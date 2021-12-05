class Solution {
    public int rob(TreeNode root) {
        int[] arr = fun(root);
        return Math.max(arr[0], arr[1]);
    }

    int[] fun(TreeNode root) {
        if (root == null)
            return new int[2];
        int[] left = fun(root.left);
        int[] right = fun(root.right);
        int ans[] = new int[2];
        ans[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        ans[1] = left[0] + right[0] + root.val;
        return ans;
    }
}
//Using class and Object
class Solution {
    public int rob(TreeNode root) {
        pair res = fun(root);
        return Math.max(res.rob, res.notrob);
    }

    public class pair {
        int rob = 0;
        int notrob = 0;
    }

    pair fun(TreeNode root) {
        if (root == null)
            return new pair();
        pair left = fun(root.left);
        pair right = fun(root.right);
        pair ans = new pair();
        ans.rob = root.val + left.notrob + right.notrob;
        ans.notrob = Math.max(left.rob, left.notrob) + Math.max(right.rob, right.notrob);
        return ans;
    }
}
