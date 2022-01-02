class Solution {
    public int trailingZeroes(int n) {
        int multipleOf5 = n / 5;
        int multipleOf25 = n / 25;
        int multipleOf125 = n / 125;
        int multiple625 = n / 625;
        int multiple3125 = n / 3125;
        return multipleOf5 + multipleOf125 + multipleOf25 + multiple625 + multiple3125;
    }
}
