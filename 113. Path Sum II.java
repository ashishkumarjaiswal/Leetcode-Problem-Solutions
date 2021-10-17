class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        fun(root, targetSum, new ArrayList<>());
        return ans;
    }

    void fun(TreeNode root, int targetSum, List<Integer> res) {
        if (root == null)
            return;
        targetSum = targetSum - root.val;
        res.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                ans.add(res);
                return;
            }
        }
        fun(root.left, targetSum, new ArrayList<>(res));
        fun(root.right, targetSum, new ArrayList<>(res));
    }
}
