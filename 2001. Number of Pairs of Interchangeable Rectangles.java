class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<String, Long> map = new HashMap<>();

        for (int[] rectangle : rectangles) {
            int x = gcd(rectangle[0], rectangle[1]);
            String s = rectangle[0] / x + " " + rectangle[1] / x;
            long temp = map.getOrDefault(s, 0l);
            map.put(s, temp + 1);
        }

        long count = 0;

        for (String s : map.keySet()) {
            long x = map.get(s);
            count = count + ((x * (x - 1)) / 2);
        }

        return count;
    }

    int gcd(int a, int b) {
        if (b == 0)
            return a;

        return gcd(b, a % b);
    }
}
