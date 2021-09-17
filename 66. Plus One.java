class Solution {
    public int[] plusOne(int[] digits) {
        int size = digits.length;
        if (digits[size - 1] != 9) {
            digits[size - 1] = digits[size - 1] + 1;
            return digits;
        }
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum = sum + digits[i];
        }

        if (sum == (size * 9)) {
            int[] arr = new int[size + 1];
            arr[0] = 1;
            return arr;
        }
        for (int i = size - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                break;
            }
        }
        return digits;
    }
}
