class Solution {
    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return createTree(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    TreeNode createTree(int[] arr, int l, int r) {
        if (arr.length <= index || arr[index] > r || arr[index] < l)
            return null;

        TreeNode ret = new TreeNode(arr[index++]);
        ret.left = createTree(arr, l, ret.val);
        ret.right = createTree(arr, ret.val, r);

        return ret;
    }
}
