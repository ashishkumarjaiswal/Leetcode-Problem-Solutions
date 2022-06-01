class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String one[] = num1.split("\\+");
        String two[] = num2.split("\\+");

        String realOne = one[0];
        String imagOne = one[1].substring(0, one[1].length() - 1);

        String realTwo = two[0];
        String imagTwo = two[1].substring(0, two[1].length() - 1);

        int a = Integer.parseInt(realOne);
        int b = Integer.parseInt(imagOne);
        int c = Integer.parseInt(realTwo);
        int d = Integer.parseInt(imagTwo);

        int real = (a * c) - (b * d);
        int imag = (a * d) + (b * c);

        return real + "+" + imag + "i";
    }
}
