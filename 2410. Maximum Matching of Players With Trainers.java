class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int count = 0;
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0, j = 0;

        while (i < players.length && j < trainers.length) {
            while (j < trainers.length && players[i] > trainers[j]) {
                j++;
            }

            if (j == trainers.length)
                return count;

            count++;
            i++;
            j++;

        }

        return count;
    }
}
