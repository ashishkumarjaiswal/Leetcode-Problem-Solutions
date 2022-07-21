class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int n = spaces.length;
        String[] arr = new String[n];
        int last = 0;

        for (int i = 0; i < n; i++) {
            // String x = sb.substring(0, spaces[i] + i) + " " + sb.substring(spaces[i] +
            // i);
            // sb = new StringBuilder();
            // sb.append(x);

            int curr = spaces[i];

            arr[i] = s.substring(last, curr);
            last = curr;
        }

        for (int i = 0; i < n; i++) {
            sb.append(arr[i]);
            sb.append(" ");
        }

        sb.append(s.substring(spaces[spaces.length - 1]));

        return sb.toString();
    }
}
