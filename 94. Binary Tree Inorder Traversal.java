class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ashish = new ArrayList<>();
        in(ashish, root);
        return ashish;
    }

    void in(List<Integer> ashish, TreeNode root) {
        if (root == null)
            return;
        in(ashish, root.left);
        ashish.add(root.val);
        in(ashish, root.right);
    }
}

// Using Morris Traversal

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            TreeNode leftwala = curr.left;
            if (leftwala == null) {
                ans.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode rightmost = rightMostNode(leftwala, curr);
                if (rightmost.right == null) {
                    rightmost.right = curr;
                    curr = curr.left;
                } else {
                    rightmost.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return ans;
    }

    TreeNode rightMostNode(TreeNode left, TreeNode curr) {
        while (left.right != null && left.right != curr) {
            left = left.right;
        }
        return left;
    }
}
