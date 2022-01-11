class Solution {
    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        fun(root, 0);
        return sum;
    }

    void fun(TreeNode root, int curr) {
        if (root == null)
            return;
        curr = curr * 2 + root.val;
        if (root.left == null && root.right == null)
            sum += curr;
        fun(root.left, curr);
        fun(root.right, curr);
    }
}


//Another approach using string list
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        fun(root, "");
        int total = 0;
        for (int i = 0; i < ans.size(); i++) {
            total = total + Integer.parseInt(ans.get(i), 2);
        }
        return total;
    }

    List<String> ans = new ArrayList<>();

    void fun(TreeNode root, String str) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            ans.add(str + root.val);
            return;
        }
        str = str + root.val;
        fun(root.left, str);
        fun(root.right, str);
        str = str.substring(0, str.length() - 1);
    }
}
