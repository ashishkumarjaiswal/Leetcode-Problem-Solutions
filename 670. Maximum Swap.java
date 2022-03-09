class Solution {
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();

        int ind = 0;
        char c = arr[0];
        boolean flag = true;

        for (int i = 0; i < arr.length && flag; i++) {
            ind = i;
            c = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] >= c && arr[j] != arr[i]) {
                    c = arr[j];
                    ind = j;
                    flag = false;
                }
            }
            if (!flag) {
                char temp = arr[i];
                arr[i] = arr[ind];
                arr[ind] = temp;
            }
        }

        String ans = "";
        for (char d : arr) {
            ans += d;
        }

        return Integer.parseInt(ans);
    }
}
