class Solution {
    public String reorderSpaces(String text) {
        String ans = "";
        String[] arr = text.trim().split(" +");
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            count += arr[i].length();
        }

        int whiteSpaceCount = text.length() - count;

        if (arr.length == 1) {
            ans = ans + arr[0];
            while (whiteSpaceCount-- > 0) {
                ans = ans + " ";
            }
            return ans;
        }

        int midSpace = whiteSpaceCount / (arr.length - 1);
        int lastSpace = whiteSpaceCount % (arr.length - 1);

        String space = "";

        while (midSpace-- > 0) {
            space += " ";
        }

        for (int i = 0; i < arr.length; i++) {
            ans = ans + arr[i] + space;
        }

        ans = ans.substring(0, ans.length() - space.length());
        while (lastSpace-- > 0) {
            ans = ans + " ";
        }

        return ans;
    }
}
