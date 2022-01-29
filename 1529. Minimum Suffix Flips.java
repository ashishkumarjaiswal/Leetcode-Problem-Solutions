class Solution {
    public int minFlips(String target) {
        int count = 0;
        boolean curr = false;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == '1') {
                if (!curr) {
                    curr = true;
                    count++;
                }
            } else {
                if (curr) {
                    curr = false;
                    count++;
                }
            }
        }
        return count;
    }
}
