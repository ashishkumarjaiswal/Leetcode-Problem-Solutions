class Solution {
    public Node connect(Node root) {
        Node ans = root;
        while (ans != null && ans.left != null) {
            Node x = ans;
            while (true) {
                x.left.next = x.right;
                if (x.next == null)
                    break;
                x.right.next = x.next.left;
                x = x.next;
            }
            ans = ans.left;
        }
        return root;
    }
}
