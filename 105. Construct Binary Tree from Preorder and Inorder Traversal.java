class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        return fun(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    TreeNode fun(int[] preorder, int[] inorder, int inStart, int inEnd, int preStart, int preEnd) {
        if (inStart > inEnd)
            return null;

        TreeNode ans = new TreeNode(preorder[preStart]);

        int find = preorder[preStart];
        int index = inStart;

        for (; index <= inEnd; index++) {
            if (inorder[index] == find)
                break;
        }

        int lts = index - inStart;
        int rts = inEnd - index;

        ans.left = fun(preorder, inorder, inStart, index - 1, preStart + 1, preEnd - rts);
        ans.right = fun(preorder, inorder, index + 1, inEnd, preEnd - rts + 1, preEnd);

        return ans;
    }
}
