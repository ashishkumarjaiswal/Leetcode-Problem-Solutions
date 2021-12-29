class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Stack<TreeNode> one = new Stack<>();
        Stack<TreeNode> two = new Stack<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        ans.add(temp);
        one.push(root);
        while (!one.isEmpty() || !two.isEmpty()) {
            temp = new ArrayList<>();
            while (!one.isEmpty()) {
                TreeNode t = one.pop();
                if (t.right != null) {
                    temp.add(t.right.val);
                    two.push(t.right);
                }
                if (t.left != null) {
                    temp.add(t.left.val);
                    two.push(t.left);
                }
            }
            if (temp.size() != 0)
                ans.add(temp);
            temp = new ArrayList<>();
            while (!two.isEmpty()) {
                TreeNode t = two.pop();
                if (t.left != null) {
                    temp.add(t.left.val);
                    one.push(t.left);
                }
                if (t.right != null) {
                    temp.add(t.right.val);
                    one.push(t.right);
                }
            }
            if (temp.size() != 0)
                ans.add(temp);

        }
        return ans;
    }
}
