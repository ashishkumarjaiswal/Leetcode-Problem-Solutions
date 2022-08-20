class Solution {
    class Pair {
        TreeNode root;
        int max;

        Pair(TreeNode root, int max) {
            this.root = root;
            this.max = max;
        }
    }

    public int goodNodes(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, root.val));
        int count = 1;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (p.root.left != null) {
                q.add(new Pair(p.root.left, Math.max(p.root.left.val, p.max)));

                if (p.root.left.val >= p.max)
                    count++;
            }

            if (p.root.right != null) {
                q.add(new Pair(p.root.right, Math.max(p.root.right.val, p.max)));

                if (p.root.right.val >= p.max)
                    count++;
            }

            // if (p.root.left == null && p.root.right == null) {
            // if (p.root.val >= p.max)
            // count++;
            // }
        }

        return count;
    }
}
