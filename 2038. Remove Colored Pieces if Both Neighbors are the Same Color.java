class Solution {
    public boolean winnerOfGame(String colors) {
        int alice = 0, bob = 0;
        int curr = 0;
        boolean flag = false;

        for (int i = 0; i < colors.length(); i++) {
            char c = colors.charAt(i);

            if (c == 'A') {
                if (flag) {
                    curr++;
                } else {
                    curr = 1;
                    flag = true;
                }
            } else {
                if (!flag) {
                    curr++;
                } else {
                    curr = 1;
                    flag = false;
                }
            }

            if (flag) {
                if (curr > 2)
                    alice++;
            } else {
                if (curr > 2)
                    bob++;
            }

        }

        return alice > bob;
    }
}
