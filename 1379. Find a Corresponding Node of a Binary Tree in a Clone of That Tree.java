import java.util.*;


class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> one = new LinkedList<>();
        Queue<TreeNode> two = new LinkedList<>();
        one.add(original);
        two.add(cloned);

        while (!one.isEmpty()) {
            TreeNode tempone = one.poll();
            TreeNode temptwo = two.poll();

            if (tempone == target) {
                return temptwo;
            }
            if (tempone.left != null) {
                one.add(tempone.left);
                two.add(temptwo.left);
            }

            if (tempone.right != null) {
                one.add(tempone.right);
                two.add(temptwo.right);
            }
        }
        return original;
    }
}
