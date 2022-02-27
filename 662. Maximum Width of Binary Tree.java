class Solution {
    class pair {
        TreeNode node;
        int index;

        pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root, 0));
        int max = 0, min = 0, ans = 0;
        ;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                pair x = q.poll();
                if (i == 0)
                    min = x.index;

                if (i == size - 1)
                    max = x.index;

                if (x.node.left != null)
                    q.add(new pair(x.node.left, 2 * x.index + 1));

                if (x.node.right != null)
                    q.add(new pair(x.node.right, 2 * x.index + 2));
            }
            ans = Math.max(ans, max - min + 1);
        }
        return ans;
    }
}
