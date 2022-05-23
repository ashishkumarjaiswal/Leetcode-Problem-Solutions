class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int x = i - 1;
            int count = 0, curr = 0;

            while (x >= 0) {
                curr++;

                if (boxes.charAt(x) == '1') {
                    count += curr;
                }

                x--;
            }

            x = i + 1;
            curr = 0;

            while (x < n) {
                curr++;

                if (boxes.charAt(x) == '1')
                    count += curr;

                x++;
            }

            ans[i] = count;
        }

        return ans;
    }
}
