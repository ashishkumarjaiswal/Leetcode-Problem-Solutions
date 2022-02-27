class Solution {
    public String truncateSentence(String s, int k) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(arr[i]);
            sb.append(" ");
        }
        return sb.toString().substring(0,sb.length()-1);
    }
}
