class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
            
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node x = q.poll();

                temp.add(x.val);

                for (int j = 0; j < x.children.size(); j++) {
                    if (x.children.get(j) != null)
                        q.add(x.children.get(j));
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}
