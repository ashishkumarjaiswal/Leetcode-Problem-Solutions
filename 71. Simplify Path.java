import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(".") || arr[i].equals("")) {
                continue;
            } else if (arr[i].equals("..")) {
                if (!s.isEmpty())
                    s.pop();
            } else {
                s.push(arr[i]);
            }
        }

        return "/" + String.join("/", s);
    }
}
