class FindElements {
    HashSet<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        set.add(0);
        fun(root.left, 0, true);
        fun(root.right, 0, false);
    }

    void fun(TreeNode root, int curr, boolean flag) {
        if (root == null)
            return;

        if (flag) {
            int next = curr * 2 + 1;
            set.add(next);
            fun(root.left, next, true);
            fun(root.right, next, false);
        } else {
            int next = curr * 2 + 2;
            set.add(next);
            fun(root.left, next, true);
            fun(root.right, next, false);
        }

    }

    public boolean find(int target) {
        return set.contains(target);
    }
}
