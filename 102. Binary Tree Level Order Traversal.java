//Using queue
//remove print add(left,right
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        q.add(root);
        while (q.size() > 0) {
            int count = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode t = q.remove();
                temp.add(t.val);
                if (t.left != null)
                    q.add(t.left);
                if (t.right != null)
                    q.add(t.right);
            }
            ans.add(temp);
        }
        return ans;
    }
}
