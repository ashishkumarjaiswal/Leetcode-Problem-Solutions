class Solution {
    public boolean isUnivalTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int x = root.val;
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp.val != x)
                return false;

            if (temp.left != null)
                q.add(temp.left);

            if (temp.right != null)
                q.add(temp.right);
        }
        return true;
    }
}
