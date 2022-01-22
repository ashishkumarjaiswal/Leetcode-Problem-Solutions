class Solution {
    public int numberOfBeams(String[] bank) {
        int total = 0, one = 0, two = 0;
        for (int i = 0; i < bank.length; i++) {
            String s = bank[i];
            int oneInRow = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1')
                    oneInRow++;
            }
            if (oneInRow == 0)
                continue;
            one = two;
            two = oneInRow;

            if (i == 0)
                continue;
            total = total + (one * two);

        }
        return total;
    }
}
