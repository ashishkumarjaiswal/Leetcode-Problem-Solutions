class Solution {
    public String sortSentence(String s) {
        String arr[] = s.split(" ");
        Arrays.sort(arr, (a, b) -> a.charAt(a.length() - 1) - b.charAt(b.length() - 1));

        String ans = "";

        for (String string : arr) {
            ans = ans + string.substring(0, string.length() - 1) + " ";
        }

        return ans.substring(0, ans.length() - 1);
    }
}
