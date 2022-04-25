class Solution {

    HashMap<TreeNode, TreeNode> map = new HashMap<>();
    HashSet<TreeNode> set = new HashSet<>();
    Queue<TreeNode> q = new LinkedList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new LinkedList<>();

        if (root == null)
            return ans;

        dfs(root, null);

        q.add(target);
        set.add(target);
        int distance = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode x = q.poll();

                if (distance == k) {
                    ans.add(x.val);
                }

                visited(x.left);
                visited(x.right);
                visited(map.getOrDefault(x, null));
            }

            distance++;

            if (distance > k)
                break;
        }

        return ans;
    }

    void dfs(TreeNode child, TreeNode parent) {
        if(child==null)
            return;
        
        if (parent != null)
            map.put(child, parent);

        dfs(child.left, child);
        dfs(child.right, child);
    }

    void visited(TreeNode node) {
        if (set.contains(node) || node == null)
            return;

        set.add(node);
        q.add(node);
    }
}
