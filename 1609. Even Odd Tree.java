class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode x;
            int y=0;

            for (int i = 0; i < size; i++) {

                x = q.poll();

                if (level % 2 == 0) {
                    if (x.val % 2 == 0)
                        return false;
                } else {
                    if (x.val % 2 != 0)
                        return false;
                }

                if (x.left != null)
                    q.add(x.left);

                if (x.right != null)
                    q.add(x.right);

                if (i == 0) {
                    y = x.val;
                    continue;
                }

                if (level % 2 == 0) {
                    if (y >= x.val)
                        return false;
                } else {
                    if (y <= x.val)
                        return false;
                }

                y = x.val;
            }
            level++;
        }
        return true;
    }
}
