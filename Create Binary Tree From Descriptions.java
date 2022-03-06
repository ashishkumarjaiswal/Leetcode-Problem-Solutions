class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashMap<Integer, Integer[]> dmap = new HashMap<>();

        for (int i = 0; i < descriptions.length; i++) {

            if (!dmap.containsKey(descriptions[i][0])) {
                dmap.put(descriptions[i][0], new Integer[2]);
            }
            if (descriptions[i][2] == 1) {
                Integer[] x = dmap.get(descriptions[i][0]);
                x[0] = descriptions[i][1];
                dmap.put(descriptions[i][0], x);
            } else {
                Integer[] x = dmap.get(descriptions[i][0]);
                x[1] = descriptions[i][1];
                dmap.put(descriptions[i][0], x);
            }
        }

        int key = 0;
        for (int is : dmap.keySet()) {
            boolean flag = true;
            for (int i = 0; i < descriptions.length; i++) {
                if (descriptions[i][1] == is) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                key = is;
        }

        for (int i : dmap.keySet()) {
            Integer l = dmap.get(i)[0];
            Integer r = dmap.get(i)[1];

            if (!map.containsKey(i)) {
                TreeNode x = new TreeNode(i);
                map.put(i, x);
            }

            TreeNode x = map.get(i);

            if (l != null) {
                if (map.containsKey(l)) {
                    TreeNode k = map.get(l);
                    x.left = k;
                } else {
                    x.left = new TreeNode(l);
                    map.put(l, x.left);
                }
            }
            if (r != null) {
                if (map.containsKey(r)) {
                    TreeNode k = map.get(r);
                    x.right = k;
                } else {
                    x.right = new TreeNode(r);
                    map.put(r, x.right);
                }
            }
        }
        return map.get(key);
    }
}
