class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return fun(root, 0);
    }

    int fun(TreeNode root, int count) {
        if (root == null)
            return 0;
        count++;
        int x = Math.max(fun(root.left, count), fun(root.right, count));
        return (x + 1);
    }
}

// Using BFS

class Solution {
    Queue<TreeNode> q = new LinkedList<>();

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
            
        int count = 0;
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode x = q.poll();
                fun(x);
            }
            count++;
        }
        return count;
    }

    void fun(TreeNode root) {
        if (root == null)
            return;

        if (root.left != null)
            q.add(root.left);

        if (root.right != null)
            q.add(root.right);

    }
}
