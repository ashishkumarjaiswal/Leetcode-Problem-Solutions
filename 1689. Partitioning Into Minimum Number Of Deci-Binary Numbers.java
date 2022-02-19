class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for (char c : n.toCharArray()) {
            int x = Integer.parseInt(c + "");
            max = Math.max(max, x);
        }
        return max;
    }
}
