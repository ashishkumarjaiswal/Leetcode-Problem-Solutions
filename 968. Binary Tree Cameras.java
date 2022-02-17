//we ask parents left and right child if any of them need cameras then we have to add one camera
//if the child already have camera so parents doesn't need any camera
//if parent's have camera so parent's parent doesn't need any camera

class Solution {
    int count = 0;

    public int minCameraCover(TreeNode root) {
        if (fun(root) == -1)
            count++;
        return count;
    }

    int fun(TreeNode root) {
        if (root == null)
            return 1;

        int left = fun(root.left);
        int right = fun(root.right);

        if (left == -1 || right == -1) {
            count++;
            return 0;
        }

        if (left == 0 || right == 0)
            return 1;

        return -1;
    }
}
