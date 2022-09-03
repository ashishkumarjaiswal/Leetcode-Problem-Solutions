class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        int count = 1;

        for (int i = 1; i < 10; i++) {
            q.add(i);
        }

        while (!q.isEmpty()) {
            if (count >= n)
                break;

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int x = q.poll();
                int lastDigit = x % 10;

                if (lastDigit + k < 10) {
                    int newDigit = x * 10 + lastDigit + k;
                    q.add(newDigit);
                }

                if (k != 0)
                    if (lastDigit - k >= 0) {
                        int newDigit = x * 10 + lastDigit - k;
                        q.add(newDigit);
                    }
            }

            count++;
        }

        int[] ans = new int[q.size()];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = q.poll();
        }

        return ans;
    }
}
