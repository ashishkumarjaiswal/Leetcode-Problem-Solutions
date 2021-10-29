public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        serial(root, s);
        return s.toString();
    }

    void serial(TreeNode root, StringBuilder s) {
        if (root == null) {
            s.append("null,");
            return;
        }
        s.append(root.val + ",");
        serial(root.left, s);
        serial(root.right, s);
    }

    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return deserial(arr);
    }

    int i = 0;

    TreeNode deserial(String[] arr) {
        if (i >= arr.length || arr[i].equals("null")) {
            i++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[i++]));
        root.left = deserial(arr);
        root.right = deserial(arr);
        return root;
    }

}
