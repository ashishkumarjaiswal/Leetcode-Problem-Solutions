class Solution {
    TreeNode rightMostNode(TreeNode node, TreeNode curr) {
        while (node.right != null && node.right != curr) {
            node = node.right;
        }
        return node;
    }

    public void recoverTree(TreeNode root) {
        TreeNode curr = root;
        TreeNode a = null, b = null, prev = null;

        while (curr != null) {
            TreeNode leftwala = curr.left;

            if (leftwala == null) {
                if (prev != null && prev.val > curr.val) {
                    if (a == null)
                        a = prev;
                    b = curr;
                }
                prev = curr;
                curr = curr.right;
            } else {
                TreeNode rightmost = rightMostNode(leftwala, curr);

                if (rightmost.right == null) {
                    rightmost.right = curr;
                    curr = curr.left;
                } else {
                    rightmost.right = null;
                    if (prev.val > curr.val) {
                        if (a == null)
                            a = prev;
                        b = curr;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        if(a!=null){
            int temp = a.val;
            a.val = b.val;
            b.val = temp;
        }
    }
}
