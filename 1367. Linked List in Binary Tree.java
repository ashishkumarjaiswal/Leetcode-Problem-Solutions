class Solution {

    public boolean isSubPath(ListNode head, TreeNode root) {
        boolean flag = isContain(head, root);

        if (root != null && !flag) {
            flag = isSubPath(head, root.left) || isSubPath(head, root.right);
        }

        return flag;
    }

    boolean isContain(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (root.val == head.val)
            return isContain(head.next, root.left) || isContain(head.next, root.right);

        return false;
    }
}
