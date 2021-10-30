class Solution {
    class BST {
        boolean bst;
        long min;
        long max;
    }

    public boolean isValidBST(TreeNode root) {
        return fun(root).bst;
    }

    BST fun(TreeNode root) {
        if (root == null) {
            BST bp = new BST();
            bp.min = Long.MAX_VALUE;
            bp.max = Long.MIN_VALUE;
            bp.bst = true;
            return bp;
        }
        BST lp = fun(root.left);
        BST rp = fun(root.right);
        BST mp = new BST();
        mp.bst = (lp.max < root.val && rp.min > root.val) && lp.bst && rp.bst;
        mp.min = Math.min(root.val, Math.min(lp.min, rp.min));
        mp.max = Math.max(root.val, Math.max(lp.max, rp.max));
        return mp;
    }
}
