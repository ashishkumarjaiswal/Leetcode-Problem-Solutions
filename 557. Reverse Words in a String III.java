class Solution {
    public String reverseWords(String s) {
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int j = i + 1;
            while (s.length() > j) {
                if (s.charAt(j) == ' ')
                    break;
                j++;
            }
            String temp = "";
            for (int k = j - 1; k >= i; k--) {
                temp = temp + s.charAt(k);
            }
            temp = temp + " ";
            i = j;
            arr.add(temp);
        }
        String ans = "";
        for (String p : arr) {
            ans = ans + p;
        }
        return ans.substring(0,ans.length()-1);
    }
}
