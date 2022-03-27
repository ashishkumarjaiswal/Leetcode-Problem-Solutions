class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Boolean[]> map = new HashMap<>();
        Boolean[] arr;

        for (int i = 0; i < reservedSeats.length; i++) {
            int r = reservedSeats[i][0];
            int c = reservedSeats[i][1];

            if (c == 1 || c == 10)
                continue;

            if (!map.containsKey(r)) {
                arr = new Boolean[3];
                arr[0] = true;
                arr[1] = true;
                arr[2] = true;
                map.put(r, arr);
            }

            arr = map.get(r);

            if (c == 2 || c == 3)
                arr[0] = false;
            else if (c == 8 || c == 9)
                arr[2] = false;
            else if (c == 4 || c == 5) {
                arr[0] = false;
                arr[1] = false;
            } else {
                arr[1] = false;
                arr[2] = false;
            }

            map.put(r, arr);
        }

        int count = (n - map.size()) * 2;

        for (int i : map.keySet()) {
            arr = map.get(i);

            if (arr[0] && arr[1] && arr[2]) {
                count = count + 2;
            } else if (arr[0] || arr[1] || arr[2]) {
                count++;
            }
        }

        return count;
    }
}
