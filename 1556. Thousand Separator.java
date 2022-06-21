class Solution {
    public String thousandSeparator(int n) {
        String num = n + "";
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        sb.reverse();
        int size = num.length();
        num = "";

        for (int i = 0; i < size; i++) {
            if ((i) % 3 == 0) {
                num = num + ".";
            }

            num = num + sb.charAt(i);
        }

        sb = new StringBuilder();
        sb.append(num);
        if (sb.charAt(0) == '.')
            sb.deleteCharAt(0);
        sb.reverse();

        return sb.toString();
    }
}
