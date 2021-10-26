class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Integer> t = new HashMap<>();
        int count = 0;
        for (int i = 0; i < jewels.length(); i++) {
            t.put(jewels.charAt(i), 0);
        }
        for (int i = 0; i < stones.length(); i++) {
            if (t.containsKey(stones.charAt(i))) {
                // t.put(stones.charAt(i), t.get(stones.charAt(i)) + 1);
                count++;
            }
        }
        return count;
    }
}
