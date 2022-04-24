import java.util.*;

class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int maxSum = Integer.MIN_VALUE, level = 1, count = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            int csum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode x = q.poll();
                csum = csum + x.val;

                if (x.left != null)
                    q.add(x.left);

                if (x.right != null)
                    q.add(x.right);
            }

            if (csum > maxSum) {
                maxSum = csum;
                level = count;
            }

            count++;
        }

        return level;
    }
}
