class Solution {
    public int findMinDifference(List<String> timePoints) {
        int ans = Integer.MAX_VALUE;
        List<Integer> list = new LinkedList<>();

        for (String s : timePoints) {
            String arr[] = s.split(":");
            int h = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);

            int totalMinute = (h * 60) + m;

            list.add(totalMinute);
        }

        Collections.sort(list);
        int a1 = list.get(list.size() - 1) - list.get(0);
        ans = Math.min(a1, 1440 - a1);

        for (int i = 1; i < list.size(); i++) {
            int temp = list.get(i) - list.get(i - 1);
            ans = Math.min(ans, temp);
        }

        return ans;
    }
}
