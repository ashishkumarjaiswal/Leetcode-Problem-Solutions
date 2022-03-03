
class Solution {
    List<Integer> l = new ArrayList<>();

    public TreeNode deleteNode(TreeNode root, int key) {
        inorder(root, key);
        return createTree(0, l.size() - 1);
    }

    TreeNode createTree(int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(l.get(mid));
        TreeNode left = createTree(start, mid-1);
        TreeNode right = createTree(mid+1, end);

        root.left = left;
        root.right = right;
        return root;
    }

    void inorder(TreeNode root, int key) {
        if (root == null)
            return;

        inorder(root.left, key);
        if (root.val != key)
            l.add(root.val);
        inorder(root.right, key);
    }
}
