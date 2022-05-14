class Solution {
    public int minimumRefill(int[] plants, int ca, int cb) {
        int a = ca, b = cb;
        int i = 0, j = plants.length - 1;
        int count = 0;

        while (i < j) {
            if (plants[i] > a) {
                count++;
                a = ca;
            }

            if (plants[j] > b) {
                count++;
                b = cb;
            }

            a = a - plants[i];
            b = b - plants[j];
            i++;
            j--;
        }

        if (i == j) {
            if (a > b) {
                if (plants[i] > a)
                    count++;
            } else {
                if (plants[i] > b)
                    count++;
            }
        }

        return count;
    }
}
