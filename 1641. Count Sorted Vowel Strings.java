class Solution {
    public int countVowelStrings(int n) {
        // if (n == 1)
        //     return 5;
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = 1;
        }
        int x = n - 1;
        while (x-- > 0) {
            for (int i = 3; i >= 0; i--) {
                arr[i] = arr[i] + arr[i + 1];
            }
        }
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            ans = ans + arr[i];
        }

        return ans;
    }
}
