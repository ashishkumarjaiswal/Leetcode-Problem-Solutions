class Solution {
    public int distributeCandies(int[] candyType) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < candyType.length; i++) {
            map.put(candyType[i], 1);
        }

        int total = candyType.length / 2;

        if (map.size() >= total) {
            return total;
        }
        return map.size();
    }
}
