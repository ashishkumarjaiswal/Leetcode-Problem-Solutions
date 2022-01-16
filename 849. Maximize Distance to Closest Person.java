class Solution {
    public int maxDistToClosest(int[] seats) {
        int maxDistance = 0;
        int i = 0;
        List<Integer> one = new ArrayList<>();
        while (i < seats.length) {
            if (seats[i] == 1)
                one.add(i);
            i++;
        }
        int formFirst = one.get(0);
        int fromLast = seats.length - 1 - one.get(one.size() - 1);
        for (int j = 1; j < one.size(); j++) {
            int x = one.get(j) - one.get(j - 1);
            x = x / 2;
            if (x > maxDistance)
                maxDistance = x;
        }
        boolean flag = false;
        if (formFirst > maxDistance) {
            maxDistance = formFirst;
            flag = true;
        }
        if (fromLast > maxDistance) {
            maxDistance = fromLast;
            flag = true;
        }
        if (flag)
            return maxDistance;
        return maxDistance;
    }
}
