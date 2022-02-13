class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length - 1;
        return fun(inorder, postorder, 0, n, 0, n);
    }

    TreeNode fun(int[] inorder, int[] postorder, int inStart, int inEnd, int pStart, int pEnd) {
        if (inEnd < inStart)
            return null;

        TreeNode ans = new TreeNode(postorder[pEnd]);
        int find = postorder[pEnd];
        int index = inStart;

        for (; index < inEnd; index++) {
            if (inorder[index] == find)
                break;
        }

        int lts = index - inStart;
        int rts = inEnd - index;

        ans.left = fun(inorder, postorder, inStart, index - 1, pStart, pEnd - rts - 1);
        ans.right = fun(inorder, postorder, index + 1, inEnd, pEnd - rts, pEnd - 1);

        return ans;
    }
}
