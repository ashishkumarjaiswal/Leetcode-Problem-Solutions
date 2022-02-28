class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        int rem = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            int x = num[i] + (k % 10) + rem;
            k = k / 10;
            rem = x / 10;
            ans.add(x % 10);
        }
        while (rem != 0 || k != 0) {
            int x = (k % 10) + rem;
            k = k / 10;
            rem = x / 10;
            ans.add(x % 10);
        }
        int i = 0, j = ans.size() - 1;
        while (i < j) {
            int temp = ans.get(i);
            ans.set(i, ans.get(j));
            ans.set(j, temp);
            i++;
            j--;
        }
        return ans;
    }
}
