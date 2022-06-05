class Solution {
    public List<String> printVertically(String s) {
        String[] arr = s.split(" ");
        int m = arr.length;
        int n = 0;
        for (String string : arr) {
            n = Math.max(n, string.length());
        }

        char[][] mat = new char[m][n];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length(); j++) {
                char c = arr[i].charAt(j);

                mat[i][j] = c;
            }
        }

        List<String> ans = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < m; j++) {
                char c = mat[j][i];

                if (c == 0) {
                    sb.append(" ");
                } else {
                    sb.append(c);
                }
            }

            String ashish = sb.toString().replaceAll("\\s+$", "");
            ans.add(ashish);
        }

        return ans;
    }
}
