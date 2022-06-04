class Solution {
    public int minBitFlips(int start, int goal) {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();

        a.append(Integer.toBinaryString(start)).reverse();
        b.append(Integer.toBinaryString(goal)).reverse();

        while (a.length() < b.length()) {
            a.append("0");
        }

        while (b.length() < a.length()) {
            b.append("0");
        }

        int count = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                count++;
        }

        return count;
    }
}
