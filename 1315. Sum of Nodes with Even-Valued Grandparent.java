class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null)
            return 0;
        int sum = 0;
        if (root.val % 2 == 0) {
            if (root.left != null && root.left.left != null)
                sum = sum + root.left.left.val;
            if (root.left != null && root.left.right != null)
                sum = sum + root.left.right.val;
            if (root.right != null && root.right.right != null)
                sum = sum + root.right.right.val;
            if (root.right != null && root.right.left != null)
                sum = sum + root.right.left.val;
        }
        sum = sum + sumEvenGrandparent(root.left);
        sum = sum + sumEvenGrandparent(root.right);
        return sum;
    }
}
