class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : answers) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int ans = 0;

        for (int i : map.keySet()) {

            int color = map.get(i);
            i++;
            int x = (int) Math.ceil((color * 1.0) / (i * 1.0));
            ans = ans + x * i;
        }
        return ans;
    }
}
