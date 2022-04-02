class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int ans = 1;
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            boolean flag = true;

            for (int i = 0; i < size; i++) {
                TreeNode x = q.poll();

                if (flag)
                    ans = x.val;

                if (x.left != null)
                    q.add(x.left);

                if (x.right != null)
                    q.add(x.right);
                    
                flag = false;
            }
        }
        return ans;
    }
}
