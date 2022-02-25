class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int num : arr)
            sum += num;

        if (sum % 3 != 0)
            return false;

        int sub = sum / 3, dots = 0, temp = 0;
        
        for (int i = 0; i < arr.length - 1; i++) {
            temp += arr[i];
            if (temp == sub) {
                dots += 1;
                temp = 0;
            }
            if (dots == 2)
                break;
        }
        return dots == 2;
    }
}
