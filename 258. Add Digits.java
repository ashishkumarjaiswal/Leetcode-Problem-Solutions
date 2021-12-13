class Solution {
    public int addDigits(int num) {
        while (num > 9) {
            int x = 0;
            while (num > 0) {
                int temp = num % 10;
                num = num / 10;
                x = x + temp;
            }
            num = x;
        }
        return num;
    }
}
