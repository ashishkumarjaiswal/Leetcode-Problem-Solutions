class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            char c = (char) ((columnNumber - 1) % 26 + 65);
            columnNumber = (columnNumber - 1) / 26;
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
