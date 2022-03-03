
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

//optimiseclass Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left != null && root.right != null) {
                int x = findMax(root.left);
                root.val = x;
                root.left = deleteNode(root.left, x);
                return root;
            } else if (root.left != null) {
                return root.left;
            } else if (root.right != null) {
                return root.right;
            } else {
                return null;
            }
        }
        return root;
    }

    int findMax(TreeNode root) {
        int max = Integer.MIN_VALUE;
        while (root != null) {
            max = Math.max(max, root.val);
            root = root.right;
        }
        return max;
    }
}
