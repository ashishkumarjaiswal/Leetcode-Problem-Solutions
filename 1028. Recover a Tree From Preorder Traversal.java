class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        HashMap<Integer, Stack<TreeNode>> map = new HashMap<>();
        TreeNode ans = new TreeNode(-1);

        for (int i = 0; i < traversal.length();) {
            int level = 0;
            while (i < traversal.length() && traversal.charAt(i) == '-') {
                level++;
                i++;
            }

            int start = i;
            int end = i;
            while (i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
                i++;
                end++;
            }

            String s = traversal.substring(start, end);
            int num = Integer.parseInt(s);

            TreeNode temp = new TreeNode(num);

            if (level == 0) {
                if (!map.containsKey(0)) {
                    map.put(0, new Stack<>());
                }

                map.get(0).push(temp);
                ans = temp;
            } else {
                Stack<TreeNode> q = map.get(level - 1);

                if (q.peek().left == null) {
                    q.peek().left = temp;
                } else {
                    q.peek().right = temp;
                }

                if (!map.containsKey(level)) {
                    map.put(level, new Stack<>());
                }

                map.get(level).push(temp);
            }
        }

        return ans;
    }
}
