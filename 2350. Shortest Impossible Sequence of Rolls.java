class Solution {
    public int shortestSequence(int[] rolls, int k) {
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;

        for (int i : rolls) {
            set.add(i);

            if (set.size() == k) {
                ans++;
                set = new HashSet<>();
            }
        }

        return ans +1 ;
    }
}
